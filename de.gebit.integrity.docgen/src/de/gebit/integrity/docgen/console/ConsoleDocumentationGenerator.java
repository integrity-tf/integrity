/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.console;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.gebit.integrity.docgen.DefaultDocumentationGenerator;
import de.gebit.integrity.docgen.DocumentationGenerator;
import de.gebit.integrity.providers.TestResourceProvider;
import de.gebit.integrity.runner.Diagnostic;
import de.gebit.integrity.runner.IntegrityDSLSetup;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.console.SimpleCommandLineParser;
import de.gebit.integrity.runner.exceptions.ModelAmbiguousException;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.runner.providers.FilesystemArchiveTestResourceProvider;

/**
 * This is a console wrapper of the documentation generator.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ConsoleDocumentationGenerator {

	/**
	 * The help string to attach for the remaining unparsed args.
	 */
	private static final String REMAINING_ARGS_HELP = " scripts...";

	/**
	 * Exit code returned if everything went well.
	 */
	public static final int EXIT_CODE_SUCCESS = 0;

	/**
	 * Exit code returned on a parameter error (necessary parameter missing, unknown parameter given etc.).
	 */
	public static final int EXIT_CODE_PARAMETER_ERROR = 1;

	/**
	 * Exit code returned on a runtime error during test execution.
	 */
	public static final int EXIT_CODE_RUNTIME_ERROR = 2;

	/**
	 * The setup class to use.
	 */
	protected Class<? extends IntegrityDSLSetup> setupClass = IntegrityDSLSetup.class;

	/**
	 * Creates a new instance using the default setup class.
	 */
	public ConsoleDocumentationGenerator() {
		// nothing to do
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetupClass
	 *            the setup class to use
	 */
	public ConsoleDocumentationGenerator(Class<? extends IntegrityDSLSetup> aSetupClass) {
		setupClass = aSetupClass;
	}

	/**
	 * Main method to be run by JRE.
	 * 
	 * @param someArgs
	 */
	public static void main(String[] someArgs) {
		ConsoleDocumentationGenerator tempGenerator = new ConsoleDocumentationGenerator();

		int tempResult = tempGenerator.run(someArgs);

		System.exit(tempResult);
	}

	/**
	 * The root method.
	 * 
	 * @param someArgs
	 * @return
	 */
	public int run(String[] someArgs) {
		SimpleCommandLineParser tempParser = new SimpleCommandLineParser();
		SimpleCommandLineParser.StringOption tempOutputDirOption = new SimpleCommandLineParser.StringOption("o",
				"output", "Target directory for generated HTML files (default: current working dir)",
				"[{-o,--output} dir]");
		SimpleCommandLineParser.BooleanOption tempSkipModelCheck = new SimpleCommandLineParser.BooleanOption(null,
				"nomodelcheck",
				"Disables model checking. This can decrease startup time, especially with big script collections, but you greatly increase the risk of getting strange NullPointerExceptions during execution due to unresolved links.",
				"[{--nomodelcheck}]");
		SimpleCommandLineParser.BooleanOption tempModelValidate = new SimpleCommandLineParser.BooleanOption(null,
				"validate",
				"Enables script validation on startup. Turning this on finds many typical errors that came past the simple parser, but it can really increase startup time.",
				"[{--validate}]");

		tempParser.addOptions(tempOutputDirOption, tempSkipModelCheck, tempModelValidate);

		if (someArgs.length == 0) {
			getStdOut().print(tempParser.getHelp(REMAINING_ARGS_HELP));
			return EXIT_CODE_PARAMETER_ERROR;
		}

		String[] tempRemainingParameters;
		try {
			tempRemainingParameters = tempParser.parseAndReturnRemaining(someArgs);
		} catch (IllegalArgumentException exc) {
			getStdErr().println(exc.getMessage());
			getStdOut().print(tempParser.getHelp(REMAINING_ARGS_HELP));
			return EXIT_CODE_PARAMETER_ERROR;
		}
		if (tempRemainingParameters.length == 0) {
			getStdErr().println("Missing mandatory script file/dir definition!");
			getStdOut().println(tempParser.getHelp(REMAINING_ARGS_HELP));
			return EXIT_CODE_PARAMETER_ERROR;
		}

		TestResourceProvider tempResourceProvider;
		try {
			tempResourceProvider = createResourceProvider(
					Arrays.asList(tempRemainingParameters).stream().map(File::new).collect(Collectors.toList()));
		} catch (IOException exc) {
			getStdErr().println("Encountered an I/O error when preparing the test script resources.");
			exc.printStackTrace(getStdErr());
			return EXIT_CODE_RUNTIME_ERROR;
		}

		try {
			TestModel tempModel = TestModel.loadTestModel(tempResourceProvider, tempSkipModelCheck.isSet(),
					tempModelValidate.isSet(), setupClass);

			DocumentationGenerator tempDocGen = createDocumentationGenerator();

			tempDocGen.initialize(tempModel);

			tempDocGen.run(new File(tempOutputDirOption.getValue(".")));
		} catch (ModelParseException exc) {
			for (Diagnostic tempDiag : exc.getErrors()) {
				getStdErr().println("Parse error in " + tempDiag.getLocation() + ": " + tempDiag.getMessage());
			}
		} catch (ValidationException exc) {
			// Print no stacktrace as the message should include a line number to the cause, which is more interesting
			getStdErr().println(exc.getMessage());
		} catch (ModelLinkException exc) {
			exc.printUnresolvableObjects(getStdErr());
		} catch (ModelAmbiguousException exc) {
			exc.printAmbiguousDefinitions(getStdErr());
		} catch (ModelLoadException exc) {
			exc.printStackTrace(getStdErr());
		} catch (Exception exc) {
			exc.printStackTrace(getStdErr());
		}

		return 0;
	}

	/**
	 * Constructs a {@link DocumentationGenerator} instance.
	 * 
	 * @return
	 */
	protected DocumentationGenerator createDocumentationGenerator() {
		return new DefaultDocumentationGenerator();
	}

	/**
	 * Creates the {@link TestResourceProvider} instance.
	 * 
	 * @param aPathList
	 *            the list with the test script paths
	 * @return a resource provider instance
	 * @throws IOException
	 */
	protected TestResourceProvider createResourceProvider(List<File> aPathList) throws IOException {
		FilesystemArchiveTestResourceProvider tempResourceProvider = new FilesystemArchiveTestResourceProvider();
		tempResourceProvider.addAllRecursively(aPathList);
		return tempResourceProvider;
	}

	/**
	 * Return the standard error stream to use.
	 * 
	 * @return the standard error stream
	 */
	protected PrintStream getStdErr() {
		return System.err;
	}

	/**
	 * Return the standard output stream to use.
	 * 
	 * @return the standard output stream
	 */
	protected PrintStream getStdOut() {
		return System.out;
	}

}
