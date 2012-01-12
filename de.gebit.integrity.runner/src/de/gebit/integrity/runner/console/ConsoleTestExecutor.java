package de.gebit.integrity.runner.console;

import jargs.gnu.CmdLineParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.gebit.integrity.dsl.DslFactory;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
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

	private ConsoleTestExecutor() {
		// is not instantiated
	}

	private static void printUsage() {
		System.err
				.println("Usage: ConsoleTestExecutor [{-c,--console}] [{-x,--xml} filename] [{-n,--name} name] [{-r,--remoteport} port] suite_name scripts...");
		System.err.println("");
		System.err.println("-c or --console enable console logging during test execution");
		System.err.println("-x or --xml enable XML file logging (supply a target filename!)");
		System.err
				.println("--xslt embeds an XML->XSLT transform into the XML file (works fine with Firefox, Opera, Safari/Chrome)");
		System.err.println("-n or --name allows to specify a name for the test run");
		System.err.println("--noremote disables remoting");
		System.err.println("-r or --remoteport allows to specify a port number to bind to for remoting");
		System.err.println("-w or --wait causes test execution to wait for a 'play' signal via remoting");
	}

	/**
	 * Main method.
	 * 
	 * @param someArgs
	 */
	public static void main(String[] someArgs) {
		CmdLineParser tempParser = new CmdLineParser();
		CmdLineParser.Option tempConsoleOption = tempParser.addBooleanOption('c', "console");
		CmdLineParser.Option tempXmlOption = tempParser.addStringOption('x', "xml");
		CmdLineParser.Option tempXsltOption = tempParser.addBooleanOption("xslt");
		CmdLineParser.Option tempNameOption = tempParser.addStringOption('n', "name");
		CmdLineParser.Option tempNoremoteOption = tempParser.addBooleanOption("noremote");
		CmdLineParser.Option tempRemoteportOption = tempParser.addIntegerOption('r', "remoteport");
		CmdLineParser.Option tempWaitForPlayOption = tempParser.addBooleanOption('w', "wait");

		try {
			tempParser.parse(someArgs);
		} catch (CmdLineParser.OptionException exc) {
			System.err.println(exc.getMessage());
			printUsage();
			System.exit(2);
		}

		String tempExecutionName = (String) tempParser.getOptionValue(tempNameOption, "unnamed");
		String tempRootSuiteName = tempParser.getRemainingArgs()[0];
		ArrayList<File> tempTestPaths = new ArrayList<File>();
		for (int i = 1; i < tempParser.getRemainingArgs().length; i++) {
			tempTestPaths.add(new File(tempParser.getRemainingArgs()[i]));
		}

		TestResourceProvider tempResourceProvider = new FilesystemTestResourceProvider(tempTestPaths, true);

		TestRunner tempRunner;
		try {
			TestModel tempModel = TestModel.loadTestModel(tempResourceProvider);
			SuiteDefinition tempRootSuite = tempModel.getSuiteByName(tempRootSuiteName);

			if (tempRootSuite == null) {
				System.err.println("Could not find root suite '" + tempRootSuiteName + "' - exiting!");
			} else {
				Suite tempRootSuiteCall = DslFactory.eINSTANCE.createSuite();
				tempRootSuiteCall.setDefinition(tempRootSuite);

				CompoundTestRunnerCallback tempCallback = new CompoundTestRunnerCallback();
				if ((Boolean) tempParser.getOptionValue(tempConsoleOption, Boolean.FALSE)) {
					tempCallback.addCallback(new ConsoleTestCallback(tempResourceProvider.getClassLoader()));
				}
				String tempXmlFileName = (String) tempParser.getOptionValue(tempXmlOption);
				if (tempXmlFileName != null) {
					tempCallback.addCallback(new XmlWriterTestCallback(tempResourceProvider.getClassLoader(), new File(
							tempXmlFileName), tempExecutionName, (Boolean) tempParser.getOptionValue(tempXsltOption,
							Boolean.FALSE)));
				}

				Integer tempRemotePort = null;
				if (!((Boolean) tempParser.getOptionValue(tempNoremoteOption, Boolean.FALSE))) {
					tempRemotePort = (Integer) tempParser.getOptionValue(tempRemoteportOption,
							IntegrityRemotingConstants.DEFAULT_PORT);
				}

				try {
					tempRunner = new TestRunner(tempModel, tempCallback, tempRemotePort, someArgs);
					tempRunner.run(tempRootSuiteCall,
							(Boolean) tempParser.getOptionValue(tempWaitForPlayOption, Boolean.FALSE));
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
