package de.integrity.runner.console;

import jargs.gnu.CmdLineParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.integrity.dsl.DslFactory;
import de.integrity.dsl.Suite;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.remoting.IntegrityRemotingConstants;
import de.integrity.runner.TestModel;
import de.integrity.runner.TestRunner;
import de.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.integrity.runner.callbacks.console.ConsoleTestCallback;
import de.integrity.runner.callbacks.xml.XmlWriterTestCallback;
import de.integrity.runner.exceptions.ModelLinkException;
import de.integrity.runner.exceptions.ModelLoadException;
import de.integrity.runner.exceptions.ModelParseException;
import de.integrity.runner.providers.FilesystemTestResourceProvider;
import de.integrity.runner.providers.TestResourceProvider;

public class ConsoleTestExecutor {

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
	 * @param args
	 */
	public static void main(String[] args) {
		CmdLineParser parser = new CmdLineParser();
		CmdLineParser.Option consoleOption = parser.addBooleanOption('c', "console");
		CmdLineParser.Option xmlOption = parser.addStringOption('x', "xml");
		CmdLineParser.Option xsltOption = parser.addBooleanOption("xslt");
		CmdLineParser.Option nameOption = parser.addStringOption('n', "name");
		CmdLineParser.Option noremoteOption = parser.addBooleanOption("noremote");
		CmdLineParser.Option remoteportOption = parser.addIntegerOption('r', "remoteport");
		CmdLineParser.Option waitForPlayOption = parser.addBooleanOption('w', "wait");

		try {
			parser.parse(args);
		} catch (CmdLineParser.OptionException e) {
			System.err.println(e.getMessage());
			printUsage();
			System.exit(2);
		}

		String tempExecutionName = (String) parser.getOptionValue(nameOption, "unnamed");
		String tempRootSuiteName = parser.getRemainingArgs()[0];
		ArrayList<File> tempTestPaths = new ArrayList<File>();
		for (int i = 1; i < parser.getRemainingArgs().length; i++) {
			tempTestPaths.add(new File(parser.getRemainingArgs()[i]));
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

				CompoundTestRunnerCallback callback = new CompoundTestRunnerCallback();
				if ((Boolean) parser.getOptionValue(consoleOption, Boolean.FALSE)) {
					callback.addCallback(new ConsoleTestCallback(tempResourceProvider.getClassLoader()));
				}
				String xmlFileName = (String) parser.getOptionValue(xmlOption);
				if (xmlFileName != null) {
					callback.addCallback(new XmlWriterTestCallback(tempResourceProvider.getClassLoader(), new File(
							xmlFileName), tempExecutionName, (Boolean) parser.getOptionValue(xsltOption, Boolean.FALSE)));
				}

				Integer tempRemotePort = null;
				if (!((Boolean) parser.getOptionValue(noremoteOption, Boolean.FALSE))) {
					tempRemotePort = (Integer) parser.getOptionValue(remoteportOption,
							IntegrityRemotingConstants.DEFAULT_PORT);
				}

				try {
					tempRunner = new TestRunner(tempModel, callback, tempRemotePort);
					tempRunner
							.run(tempRootSuiteCall, (Boolean) parser.getOptionValue(waitForPlayOption, Boolean.FALSE));
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		} catch (ModelParseException e) {
			for (Diagnostic tempDiag : e.getErrors()) {
				System.err.println("Parse error in " + tempDiag.getLocation() + ": " + tempDiag.getMessage());
			}
		} catch (ModelLinkException e) {
			Iterator<EObject> tempIter = e.getUnresolvableObjects().iterator();
			while (tempIter.hasNext()) {
				EObject tempUnresolved = tempIter.next();
				System.err.println("Unresolved reference " + tempUnresolved);
			}
		} catch (ModelLoadException e) {
			e.printStackTrace();
		}
	}
}
