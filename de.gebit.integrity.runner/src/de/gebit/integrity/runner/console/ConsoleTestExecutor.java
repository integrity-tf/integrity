package de.gebit.integrity.runner.console;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.gebit.integrity.dsl.DslFactory;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.TestRunner;
import de.gebit.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.console.ConsoleTestCallback;
import de.gebit.integrity.runner.callbacks.xml.XmlWriterTestCallback;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.providers.FilesystemTestResourceProvider;
import de.gebit.integrity.runner.providers.TestResourceProvider;

/**
 * A basic program to run Integrity tests from the console.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public final class ConsoleTestExecutor {

	/**
	 * The help string to attach for the remaining unparsed args.
	 */
	private static final String REMAINING_ARGS_HELP = " suite_name scripts...";

	private ConsoleTestExecutor() {
		// is not instantiated
	}

	/**
	 * Main method.
	 * 
	 * @param someArgs
	 */
	public static void main(String[] someArgs) {
		SimpleCommandLineParser tempParser = new SimpleCommandLineParser();
		SimpleCommandLineParser.BooleanOption tempConsoleOption = new SimpleCommandLineParser.BooleanOption("s",
				"silent", "Disable console logging during test execution", "[{-s,--silent}]");
		SimpleCommandLineParser.StringOption tempXmlOption = new SimpleCommandLineParser.StringOption("x", "xml",
				"Enable XML file logging (supply a target filename!)", "[{-x,--xml} filename]");
		SimpleCommandLineParser.BooleanOption tempXsltOption = new SimpleCommandLineParser.BooleanOption(null,
				"noxslt", "Disables embedding of the XML->XHTML transform into the XML file", "[{--noxslt}]");
		SimpleCommandLineParser.StringOption tempNameOption = new SimpleCommandLineParser.StringOption("n", "name",
				"Specify a name for the test run", "[{-n,--name}]");
		SimpleCommandLineParser.StringOption tempVariantOption = new SimpleCommandLineParser.StringOption("v",
				"variant", "Specify the variant to execute (must be defined in the scripts!)", "[{-v,--variant}]");
		SimpleCommandLineParser.BooleanOption tempNoremoteOption = new SimpleCommandLineParser.BooleanOption(null,
				"noremote", "Disables remoting", "[{--noremote}]");
		SimpleCommandLineParser.IntegerOption tempRemoteportOption = new SimpleCommandLineParser.IntegerOption("r",
				"remoteport", "Set the port number to bind to for remoting (default is "
						+ IntegrityRemotingConstants.DEFAULT_PORT + ")", "[{-r,--remoteport} port]");
		SimpleCommandLineParser.StringOption tempRemoteHostOption = new SimpleCommandLineParser.StringOption(
				"remotehost", "Set the host name or IP to which the remoting server should bind (default is 0.0.0.0)",
				"[{--remotehost} host]");
		SimpleCommandLineParser.BooleanOption tempWaitForPlayOption = new SimpleCommandLineParser.BooleanOption("w",
				"wait", "Wait with test execution for a 'play' signal via remoting", "[{-w,--wait}]");
		SimpleCommandLineParser.BooleanOption tempNoResolveAllReferences = new SimpleCommandLineParser.BooleanOption(
				null,
				"noresolve",
				"Disable pre-executional resolving of all references in the loaded scripts. May significantly speed up the starting phase, but you risk getting strange NullPointerExceptions during execution.",
				"[{--noresolve}]");

		tempParser.addOptions(tempConsoleOption, tempXmlOption, tempXsltOption, tempNameOption, tempVariantOption,
				tempNoremoteOption, tempRemoteportOption, tempRemoteHostOption, tempWaitForPlayOption,
				tempNoResolveAllReferences);

		if (someArgs.length == 0) {
			System.out.print(tempParser.getHelp(REMAINING_ARGS_HELP));
			System.exit(2);
			return;
		}

		String[] tempRemainingParameters;
		try {
			tempRemainingParameters = tempParser.parseAndReturnRemaining(someArgs);
		} catch (IllegalArgumentException exc) {
			System.err.println(exc.getMessage());
			System.out.print(tempParser.getHelp(REMAINING_ARGS_HELP));
			System.exit(2);
			return;
		}

		String tempExecutionName = tempNameOption.getValue("unnamed");
		String tempRootSuiteName = tempRemainingParameters[0];
		ArrayList<File> tempTestPaths = new ArrayList<File>();
		for (int i = 1; i < tempRemainingParameters.length; i++) {
			tempTestPaths.add(new File(tempRemainingParameters[i]));
		}

		TestResourceProvider tempResourceProvider = new FilesystemTestResourceProvider(tempTestPaths, true);

		TestRunner tempRunner;
		try {
			TestModel tempModel = TestModel.loadTestModel(tempResourceProvider, !tempNoResolveAllReferences.isSet());
			SuiteDefinition tempRootSuite = tempModel.getSuiteByName(tempRootSuiteName);
			VariantDefinition tempVariant = null;

			if (tempVariantOption.getValue() != null) {
				tempVariant = tempModel.getVariantByName(tempVariantOption.getValue());
				if (tempVariant == null) {
					System.err.println("Could not find variant '" + tempVariantOption.getValue() + "' - exiting!");
					return;
				}
			}

			if (tempRootSuite == null) {
				System.err.println("Could not find root suite '" + tempRootSuiteName + "' - exiting!");
				return;
			} else {
				Suite tempRootSuiteCall = DslFactory.eINSTANCE.createSuite();
				tempRootSuiteCall.setDefinition(tempRootSuite);

				CompoundTestRunnerCallback tempCallback = new CompoundTestRunnerCallback();
				if (!tempConsoleOption.isSet()) {
					tempCallback.addCallback(new ConsoleTestCallback(tempResourceProvider.getClassLoader()));
				}
				String tempXmlFileName = tempXmlOption.getValue();
				if (tempXmlFileName != null) {
					tempCallback.addCallback(new XmlWriterTestCallback(tempResourceProvider.getClassLoader(), new File(
							tempXmlFileName), tempExecutionName, !tempXsltOption.isSet()));
				}

				Integer tempRemotePort = null;
				String tempRemoteHost = null;
				if (!tempNoremoteOption.isSet()) {
					tempRemotePort = tempRemoteportOption.getValue(IntegrityRemotingConstants.DEFAULT_PORT);
					tempRemoteHost = tempRemoteHostOption.getValue("0.0.0.0");
				}

				try {
					tempRunner = new TestRunner(tempModel, tempCallback, tempRemotePort, tempRemoteHost, someArgs);
					tempRunner.run(tempRootSuiteCall, tempVariant, tempWaitForPlayOption.isSet());
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		} catch (ModelParseException exc) {
			for (Diagnostic tempDiag : exc.getErrors()) {
				System.err.println("Parse error in " + tempDiag.getLocation() + ": " + tempDiag.getMessage());
			}
		} catch (ModelLinkException exc) {
			Iterator<EObject> tempIter = exc.getUnresolvableObjects().iterator();
			while (tempIter.hasNext()) {
				EObject tempUnresolved = tempIter.next();
				System.err.println("Unresolved reference " + tempUnresolved);
			}
		} catch (ModelLoadException exc) {
			exc.printStackTrace();
		}
	}
}
