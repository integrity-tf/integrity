/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.runner.IntegrityDSLSetup;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.TestRunner;
import de.gebit.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.callbacks.console.ConsoleTestCallback;
import de.gebit.integrity.runner.callbacks.xml.TransformHandling;
import de.gebit.integrity.runner.callbacks.xml.XmlWriterTestCallback;
import de.gebit.integrity.runner.exceptions.ModelAmbiguousException;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.runner.providers.FilesystemArchiveTestResourceProvider;
import de.gebit.integrity.runner.providers.TestResourceProvider;

/**
 * A basic program to run Integrity tests from the console. This class has a main method, but you can also instantiate
 * it on your own from a different entry point, like your own main method or similar. If you instantiate it for
 * yourself, you can supply a setup class (subclass of {@link IntegrityDSLSetup}) which can be used to influence the
 * Guice initialization, for example in order to replace certain services provided via Guice injection with subclasses
 * of your own.<br>
 * <br>
 * There are various designated hooking points in this class which are designed to be overridden in subclasses, with the
 * ultimate purpose of making it easy to implement common customizations with very little code (duplication).
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConsoleTestExecutor {

	/**
	 * The help string to attach for the remaining unparsed args.
	 */
	private static final String REMAINING_ARGS_HELP = " suite_name scripts...";

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
	 * Stores a list of (weakly referenced) threads which were already running before the test run is started.
	 */
	protected WeakHashMap<Thread, Boolean> threadsRunningBeforeTestExecution = new WeakHashMap<Thread, Boolean>();

	/**
	 * Creates a new instance using the default setup class.
	 */
	public ConsoleTestExecutor() {
		// nothing to do
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetupClass
	 *            the setup class to use
	 */
	public ConsoleTestExecutor(Class<? extends IntegrityDSLSetup> aSetupClass) {
		setupClass = aSetupClass;
	}

	/**
	 * Main method.
	 * 
	 * @param someArgs
	 */
	public static void main(String[] someArgs) {
		ConsoleTestExecutor tempExecutor = new ConsoleTestExecutor();

		int tempReturnCode = tempExecutor.runWithZombieThreadDetection(someArgs);

		System.exit(tempReturnCode);
	}

	/**
	 * Takes note of all threads which are currently running by using the {@link #threadsRunningBeforeTestExecution}
	 * map. This is used in conjunction with {@link #checkForZombieThreads()}.
	 */
	public void prepareZombieThreadCheck() {
		Thread[] tempArray = new Thread[Thread.activeCount()];
		Thread.enumerate(tempArray);

		threadsRunningBeforeTestExecution.clear();
		for (Thread tempThread : tempArray) {
			if (tempThread.isAlive() && !tempThread.isDaemon()) {
				threadsRunningBeforeTestExecution.put(tempThread, true);
			}
		}
	}

	/**
	 * Searches for any threads still running which were not running when {@link #prepareZombieThreadCheck()} was
	 * executed and prints them on the console. This mechanism is designed to find
	 */
	public void checkForZombieThreads() {
		Thread[] tempArray = new Thread[Thread.activeCount()];
		Thread.enumerate(tempArray);

		List<Thread> tempZombieThreads = new LinkedList<Thread>();
		for (Thread tempThread : tempArray) {
			if (!threadsRunningBeforeTestExecution.containsKey(tempThread) && tempThread.isAlive()
					&& !tempThread.isDaemon()) {
				tempZombieThreads.add(tempThread);
			}
		}

		if (tempZombieThreads.size() > 0) {
			getStdOut().println(
					"WARNING: Found " + tempZombieThreads.size()
							+ " zombie thread(s) still alive after test run has ended. "
							+ "These should not exist - you are responsible to terminate "
							+ "all threads being started during test execution!");
			for (Thread tempThread : tempZombieThreads) {
				getStdOut().println("  Thread #" + tempThread.getId() + ": " + tempThread.getName());
			}
		}
	}

	/**
	 * Works like {@link #run(String[])}, but performs zombie thread detection as well. See
	 * {@link #checkForZombieThreads()} for details.
	 * 
	 * @param someArgs
	 *            the command-line arguments
	 * @return the exit code
	 */
	public int runWithZombieThreadDetection(String[] someArgs) {
		try {
			prepareZombieThreadCheck();
			return run(someArgs);
		} finally {
			// At this point, all threads started by the test run should have finished.
			checkForZombieThreads();
		}
	}

	/**
	 * This is basically the actual "main" method. It instantiates the test model, runner etc. and executes the test.
	 * 
	 * @param someArgs
	 *            the command-line arguments
	 * @return the exit code
	 */
	public int run(String[] someArgs) {
		SimpleCommandLineParser tempParser = new SimpleCommandLineParser();
		SimpleCommandLineParser.BooleanOption tempConsoleOption = new SimpleCommandLineParser.BooleanOption("s",
				"silent", "Disable console logging during test execution", "[{-s,--silent}]");
		SimpleCommandLineParser.StringOption tempXmlOption = new SimpleCommandLineParser.StringOption("x", "xhtml",
				"Enable XHTML/XML file logging (supply a target filename!)", "[{-x,--xhtml} filename]");
		SimpleCommandLineParser.StringOption tempXsltOption = new SimpleCommandLineParser.StringOption(
				null,
				"xslt",
				"Specify how the XML->XHTML transformation of the result shall be handled. Valid options are 'none' (output is plain XML), 'embed' (embed stylesheet in XML output) and 'execute' (execute immediately; default setting).",
				"[{--xslt} none|embed|execute]");
		SimpleCommandLineParser.StringOption tempNameOption = new SimpleCommandLineParser.StringOption("n", "name",
				"Specify a name for the test run", "[{-n,--name}]");
		SimpleCommandLineParser.StringOption tempVariantOption = new SimpleCommandLineParser.StringOption("v",
				"variant", "Specify the variant to execute (must be defined in the scripts!)", "[{-v,--variant}]");
		SimpleCommandLineParser.BooleanOption tempNoremoteOption = new SimpleCommandLineParser.BooleanOption(null,
				"noremote", "Disables remoting", "[{--noremote}]");
		SimpleCommandLineParser.IntegerOption tempRemoteportOption = new SimpleCommandLineParser.IntegerOption("r",
				"remoteport", "Set the port number to bind to for remoting (default is "
						+ IntegrityRemotingConstants.DEFAULT_PORT + ")", "[{-r,--remoteport} port]");
		SimpleCommandLineParser.StringOption tempRemoteHostOption = new SimpleCommandLineParser.StringOption(null,
				"remotehost", "Set the host name or IP to which the remoting server should bind (default is 0.0.0.0)",
				"[{--remotehost} host]");
		SimpleCommandLineParser.BooleanOption tempWaitForPlayOption = new SimpleCommandLineParser.BooleanOption("w",
				"wait", "Wait with test execution for a 'play' signal via remoting", "[{-w,--wait}]");
		SimpleCommandLineParser.BooleanOption tempSkipModelCheck = new SimpleCommandLineParser.BooleanOption(
				null,
				"nomodelcheck",
				"Disables model checking. This can decrease startup time, especially with big script collections, but you greatly increase the risk of getting strange NullPointerExceptions during execution due to unresolved links.",
				"[{--nomodelcheck}]");
		SimpleCommandLineParser.StringOption tempParameterizedConstantOption = new SimpleCommandLineParser.StringOption(
				"p", "parameter", "Define a parameterized constants' value (can be used multiple times!)",
				"[{-p,--parameter} fully.qualified.constant.name=value]");
		SimpleCommandLineParser.LongOption tempSeedOption = new SimpleCommandLineParser.LongOption(null, "seed",
				"Sets the seed number to use for the RNG custom operation", "[{--seed} number]");
		SimpleCommandLineParser.BooleanOption tempExcludeConsoleStreamsOption = new SimpleCommandLineParser.BooleanOption(
				null, "noconsole", "Do not capture stdout & stderr for test XML/HTML output", "[{--noconsole}]");

		tempParser.addOptions(tempConsoleOption, tempXmlOption, tempXsltOption, tempNameOption, tempVariantOption,
				tempNoremoteOption, tempRemoteportOption, tempRemoteHostOption, tempWaitForPlayOption,
				tempSkipModelCheck, tempParameterizedConstantOption, tempSeedOption, tempExcludeConsoleStreamsOption);

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
			getStdErr().println("Missing mandatory 'root_suite' definition!");
			getStdOut().println(tempParser.getHelp(REMAINING_ARGS_HELP));
			return EXIT_CODE_PARAMETER_ERROR;
		}

		TransformHandling tempTransformHandling = evaluateTransformHandling(tempXsltOption);
		String tempExecutionName = tempNameOption.getValue("unnamed");
		String tempRootSuiteName = getRootSuiteNameFrom(tempRemainingParameters);
		TestResourceProvider tempResourceProvider;
		try {
			tempResourceProvider = createResourceProvider(getScriptsList(tempRemainingParameters));
		} catch (IOException exc) {
			getStdErr().println("Encountered an I/O error when preparing the test script resources.");
			exc.printStackTrace(getStdErr());
			return EXIT_CODE_RUNTIME_ERROR;
		}

		try {
			TestModel tempModel = TestModel.loadTestModel(tempResourceProvider, tempSkipModelCheck.isSet(), setupClass);
			SuiteDefinition tempRootSuite = tempModel.getSuiteByName(tempRootSuiteName);
			VariantDefinition tempVariant = null;

			if (tempVariantOption.getValue() != null) {
				tempVariant = tempModel.getVariantByName(tempVariantOption.getValue());
				if (tempVariant == null) {
					getStdErr().println("Could not find variant '" + tempVariantOption.getValue() + "' - exiting!");
					return EXIT_CODE_PARAMETER_ERROR;
				}
			}

			Map<String, String> tempParameterizedConstants = new HashMap<String, String>();
			for (String tempOptionValue : tempParameterizedConstantOption.getValues()) {
				String[] tempParts = tempOptionValue.split("=", 2);
				if (tempParts.length < 2) {
					getStdErr().println(
							"Could not parse parameterized constant definition '" + tempOptionValue
									+ "' - definitions must follow the pattern 'fully.qualified.constant.name=value'!");
					return EXIT_CODE_PARAMETER_ERROR;
				} else {
					tempParameterizedConstants.put(tempParts[0], tempParts[1]);
				}
			}
			addParameterizedConstants(tempParameterizedConstants);

			if (tempRootSuite == null) {
				getStdErr().println("Could not find root suite '" + tempRootSuiteName + "' - exiting!");
				return EXIT_CODE_PARAMETER_ERROR;
			} else {
				CompoundTestRunnerCallback tempCallback = new CompoundTestRunnerCallback();
				if (!tempConsoleOption.isSet()) {
					tempCallback.addCallback(createConsoleTestCallback());
				}
				String tempXmlFileName = tempXmlOption.getValue();

				if (tempXmlFileName != null) {
					tempCallback.addCallback(createXmlWriterTestCallback(tempResourceProvider, tempXmlFileName,
							tempExecutionName, tempTransformHandling, !tempExcludeConsoleStreamsOption.isSet()));
				}

				List<TestRunnerCallback> tempAdditionalCallbacks = createAdditionalCallbacks();
				if (tempAdditionalCallbacks != null) {
					for (TestRunnerCallback tempCallbackToAdd : tempAdditionalCallbacks) {
						tempCallback.addCallback(tempCallbackToAdd);
					}
				}

				Integer tempRemotePort = null;
				String tempRemoteHost = null;
				if (!tempNoremoteOption.isSet()) {
					tempRemotePort = tempRemoteportOption.getValue(IntegrityRemotingConstants.DEFAULT_PORT);
					tempRemoteHost = tempRemoteHostOption.getValue("0.0.0.0");
				}

				Long tempSeed = tempSeedOption.getValue();

				try {
					TestRunner tempRunner = initializeTestRunner(tempModel, tempCallback, tempParameterizedConstants,
							tempRemotePort, tempRemoteHost, tempSeed, someArgs);
					runTests(tempRunner, tempRootSuite, tempVariant, tempWaitForPlayOption.isSet());

					return EXIT_CODE_SUCCESS;
				} catch (ModelRuntimeLinkException exc) {
					getStdErr().println("Test execution was aborted due to a test script linking error!");
					getStdErr().println(exc.getMessage());
				}
			}
		} catch (ModelParseException exc) {
			for (Diagnostic tempDiag : exc.getErrors()) {
				getStdErr().println("Parse error in " + tempDiag.getLocation() + ": " + tempDiag.getMessage());
			}
		} catch (ValidationException exc) {
			// Print no stacktrace as the message should include a line number to the cause, which is more interesting
			getStdErr().println(exc.getMessage());
		} catch (ModelLinkException exc) {
			exc.printUnresolvableObjects();
		} catch (ModelAmbiguousException exc) {
			exc.printAmbiguousDefinitions();
		} catch (ModelLoadException exc) {
			exc.printStackTrace(getStdErr());
		} catch (Exception exc) {
			exc.printStackTrace(getStdErr());
		}

		return EXIT_CODE_RUNTIME_ERROR;
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

	/**
	 * Creates the console printout test runner callback. This is an override spot for subclasses.
	 * 
	 * @return the console test callback to use
	 */
	protected TestRunnerCallback createConsoleTestCallback() {
		return new ConsoleTestCallback();
	}

	/**
	 * Instantiates the XML Test Writer Callback which is used to write the XML test results. This is an override spot
	 * for subclasses.
	 * 
	 * @param aResourceProvider
	 *            the resource provider to use (classloader is taken from there)
	 * @param anXmlFileName
	 *            the file to write the result into
	 * @param anExecutionName
	 *            the title of the result
	 * @param aTransformHandling
	 *            how the XML -> XHTML transform shall be handled
	 * @param aCaptureConsoleFlag
	 *            whether stdout and stderr shall be captured
	 * @return the XML test writer callback to use
	 */
	protected TestRunnerCallback createXmlWriterTestCallback(TestResourceProvider aResourceProvider,
			String anXmlFileName, String anExecutionName, TransformHandling aTransformHandling,
			boolean aCaptureConsoleFlag) {
		return new XmlWriterTestCallback(aResourceProvider.getClassLoader(), new File(anXmlFileName), anExecutionName,
				aTransformHandling, aCaptureConsoleFlag);
	}

	/**
	 * Extracts the root suite name from the remaining parameters.
	 * 
	 * @param someRemainingParameters
	 *            Where to extract the root suite name from.
	 * @return the root suite name
	 */
	protected String getRootSuiteNameFrom(String[] someRemainingParameters) {
		return someRemainingParameters[0]; // Can't be null, this should have been previously checked
	}

	/**
	 * Returns all script references from the remaining unparsed parameters.
	 * 
	 * @param someRemainingParameters
	 *            Unparsed parameters not matched by the options.
	 * @return List of script file references.
	 */
	protected List<File> getScriptsList(String[] someRemainingParameters) {
		List<File> tempTestPaths = new ArrayList<File>();
		// Skip the first one (0-based), scripts start at the second entry
		for (int i = 1; i < someRemainingParameters.length; i++) {
			tempTestPaths.add(new File(someRemainingParameters[i]));
		}
		return tempTestPaths;
	}

	/**
	 * Evaluates the given option and chooses a transformation handling from it.
	 * 
	 * @param anXsltOption
	 *            Option to be evaluated.
	 * @return The chosen transformation handling.
	 */
	protected TransformHandling evaluateTransformHandling(SimpleCommandLineParser.StringOption anXsltOption) {
		if (anXsltOption.getValue() == null) {
			return TransformHandling.EXECUTE_TRANSFORM;
		}
		if ("none".equals(anXsltOption.getValue())) {
			return TransformHandling.NO_TRANSFORM;
		} else if ("embed".equals(anXsltOption.getValue())) {
			return TransformHandling.EMBED_TRANSFORM;
		} else if ("execute".equals(anXsltOption.getValue())) {
			return TransformHandling.EXECUTE_TRANSFORM;
		} else {
			System.err.println("--xslt option value '" + anXsltOption.getValue()
					+ "' not understood; valid values are 'none', 'embed', 'execute'.");
			return TransformHandling.EXECUTE_TRANSFORM;
		}
	}

	/**
	 * This is a designated override point to allow for additional callbacks to be easily integrated into a test run.
	 * Any callbacks returned here are added to the basic callbacks created for a test run (usually a console output
	 * callback and an XML file output callback, but these can be customized by startup options).
	 * 
	 * @return
	 */
	protected List<TestRunnerCallback> createAdditionalCallbacks() {
		// default implementation doesn't create anything to add
		return null;
	}

	/**
	 * This method can be overridden to add some parameterized constants, which are defined in a test suite, if it is
	 * not desired to define those constants via VM arguments. The default implementation does nothing.
	 * 
	 * @param someParameterizedConstants
	 *            the map containing the constants and their values
	 */
	protected void addParameterizedConstants(Map<String, String> someParameterizedConstants) {
		// do nothing
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
	 * Initializes a {@link TestRunner} instance using the provided {@link TestModel}.
	 * 
	 * @param aModel
	 *            the model
	 * @param aCallback
	 *            the callback to use
	 * @param someParameterizedConstants
	 *            all parameterized constants to provide to the test runner
	 * @param aRemotingPort
	 *            the remoting port to use by the test runner
	 * @param aRemotingBindHost
	 *            the host to bind the remoting port to
	 * @param aRandomSeed
	 *            the seed value for the RNG
	 * @param someCommandLineArguments
	 *            the command line arguments to use for forking
	 * @return the initialized test runner
	 * @throws IOException
	 */
	protected TestRunner initializeTestRunner(TestModel aModel, TestRunnerCallback aCallback,
			Map<String, String> someParameterizedConstants, Integer aRemotingPort, String aRemotingBindHost,
			Long aRandomSeed, String[] someCommandLineArguments) throws IOException {
		return aModel.initializeTestRunner(aCallback, someParameterizedConstants, aRemotingPort, aRemotingBindHost,
				aRandomSeed, someCommandLineArguments);
	}

	/**
	 * Run the tests on the provided {@link TestRunner}.
	 * 
	 * @param aRunner
	 *            the runner
	 * @param aRootSuite
	 *            the root suite to run
	 * @param aVariant
	 *            the variant to run
	 * @param aBlockForRemotingFlag
	 *            whether to wait for remoting to start the tests
	 */
	protected void runTests(TestRunner aRunner, SuiteDefinition aRootSuite, VariantDefinition aVariant,
			boolean aBlockForRemotingFlag) {
		aRunner.run(aRootSuite, aVariant, aBlockForRemotingFlag);
	}
}
