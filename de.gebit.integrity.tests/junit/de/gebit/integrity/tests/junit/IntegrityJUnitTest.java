package de.gebit.integrity.tests.junit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.TestRunner;
import de.gebit.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.callbacks.console.ConsoleTestCallback;
import de.gebit.integrity.runner.callbacks.xml.TransformHandling;
import de.gebit.integrity.runner.callbacks.xml.XmlWriterTestCallback;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.providers.FilesystemTestResourceProvider;
import de.gebit.integrity.runner.providers.TestResourceProvider;

/**
 * Abstract base class for Integrity JUnit tests.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class IntegrityJUnitTest {

	/**
	 * Directory where reference result files are located.
	 */
	private static final String REFERENCE_RESULT_DIRECTORY = "results/";

	/**
	 * Runs a specified Integrity suite in a freshly started test runner. The result XML document is returned.
	 * 
	 * @param aSuiteName
	 *            the name of the root suite
	 * @return the result document
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	protected Document executeIntegritySuite(String[] someFileNames, String aSuiteName, String aVariantName)
			throws ModelLoadException, IOException, JDOMException {
		File tempXmlFile = null;

		List<File> tempFileList = new ArrayList<File>();
		tempFileList.add(new File("integrity/fixtures"));
		for (String tempFileName : someFileNames) {
			tempFileList.add(new File(tempFileName));
		}

		TestResourceProvider tempResourceProvider = new FilesystemTestResourceProvider(tempFileList, true);
		TestModel tempModel = TestModel.loadTestModel(tempResourceProvider, false);

		boolean tempKeepFiles = "true".equals(System.getProperty("keepFiles"));
		try {
			if (tempKeepFiles) {
				tempXmlFile = new File(getTempDir(), aSuiteName + ".xml");
			} else {
				tempXmlFile = File.createTempFile("integrityJUnit", ".xml");
			}

			TestRunnerCallback tempCallback = new CompoundTestRunnerCallback(new ConsoleTestCallback(),
					new XmlWriterTestCallback(getClass().getClassLoader(), tempXmlFile, "Integrity JUnit Testing",
							TransformHandling.NO_TRANSFORM));

			TestRunner tempRunner = tempModel.initializeTestRunner(tempCallback, null, null, null);
			tempRunner.run(tempModel.getSuiteByName(aSuiteName), tempModel.getVariantByName(aVariantName), false);
			tempRunner.shutdown(true);

			SAXBuilder tempBuilder = new SAXBuilder(false);
			return tempBuilder.build(tempXmlFile);
		} finally {
			if (tempKeepFiles) {
				System.out.println("Kept result file " + tempXmlFile.getAbsolutePath());
			} else {
				if (tempXmlFile != null) {
					tempXmlFile.delete();
				}
			}
		}
	}

	/**
	 * Checks whether a given document matches its reference document. The name of the reference doc is determined by
	 * the root suite name in the given doc and the reference XML dir {@link #REFERENCE_RESULT_DIRECTORY}.
	 * 
	 * @param aDoc
	 *            the document to compare
	 * @throws JDOMException
	 * @throws IOException
	 */
	protected void assertDocumentMatchesReference(Document aDoc) throws JDOMException, IOException {
		assertNotNull(aDoc);

		String tempRootSuiteName = aDoc.getRootElement().getChild("suite").getAttribute("name").getValue();

		SAXBuilder tempBuilder = new SAXBuilder(false);
		Document tempRef = tempBuilder.build(new File(REFERENCE_RESULT_DIRECTORY + tempRootSuiteName + ".xml"));

		removeDurationsAndTimes(aDoc.getRootElement());
		removeDurationsAndTimes(tempRef.getRootElement());

		ByteArrayOutputStream tempDocStream = new ByteArrayOutputStream();
		ByteArrayOutputStream tempRefStream = new ByteArrayOutputStream();

		XMLOutputter tempSerializer = new XMLOutputter(Format.getCompactFormat());
		tempSerializer.output(aDoc, tempDocStream);
		tempSerializer.output(tempRef, tempRefStream);

		try {
			assertTrue(Arrays.equals(tempDocStream.toByteArray(), tempRefStream.toByteArray()));
		} catch (AssertionFailedError exc) {
			System.out.println("--- Suite " + tempRootSuiteName + " failed comparison to reference data!");
			System.out.print("Reference: ");
			System.out.println(new String(tempRefStream.toByteArray(), "UTF-8"));
			System.out.print("Actual: ");
			System.out.println(new String(tempDocStream.toByteArray(), "UTF-8"));
			throw exc;
		}
	}

	private void removeDurationsAndTimes(Element anElement) throws JDOMException {
		clearAttribute(anElement, "duration");
		clearAttribute(anElement, "timestamp");
		clearAttribute(anElement, "isotimestamp");

		for (Object tempChild : anElement.getChildren()) {
			if (tempChild instanceof Element) {
				removeDurationsAndTimes((Element) tempChild);
			}
		}
	}

	private void clearAttribute(Element anElement, String anAttributeName) {
		Attribute tempAttr = anElement.getAttribute(anAttributeName);
		if (tempAttr != null) {
			tempAttr.setValue("");
		}
	}

	/**
	 * Buffer for the temporary file dir.
	 */
	private static File temporaryFileDirectory;

	private static File getTempDir() throws IOException {
		if (temporaryFileDirectory == null) {
			File tempFile = File.createTempFile("integrityJUnit", ".xml");
			temporaryFileDirectory = tempFile.getParentFile();
			tempFile.delete();
		}
		return temporaryFileDirectory;
	}

}
