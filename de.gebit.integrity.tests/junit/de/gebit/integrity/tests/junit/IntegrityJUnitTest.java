/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

/**
 * Abstract base class for Integrity JUnit tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class IntegrityJUnitTest {

	/**
	 * Directory where reference result files are located.
	 */
	private static final String REFERENCE_RESULT_DIRECTORY = "results/";

	/**
	 * Pattern to replace object IDs.
	 */
	private static final Pattern OBJECT_ID_PATTERN = Pattern.compile("^(.*@)[0-9,a-f]+$");

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
		return executeIntegritySuite(someFileNames, aSuiteName, aVariantName, false);
	}

	/**
	 * Runs a specified Integrity suite in a freshly started test runner. The result XML document is returned.
	 * 
	 * @param aSuiteName
	 *            the name of the root suite
	 * @param aCaptureConsoleFlag
	 *            whether the console shall be captured
	 * @return the result document
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	protected Document executeIntegritySuite(String[] someFileNames, String aSuiteName, String aVariantName,
			boolean aCaptureConsoleFlag) throws ModelLoadException, IOException, JDOMException {
		File tempXmlFile = null;

		List<File> tempFileList = new ArrayList<File>();
		tempFileList.add(new File("integrity/fixtures"));
		for (String tempFileName : someFileNames) {
			tempFileList.add(new File(tempFileName));
		}

		FilesystemTestResourceProvider tempResourceProvider = new FilesystemTestResourceProvider();
		tempResourceProvider.addAllRecursively(tempFileList);
		TestModel tempModel = TestModel.loadTestModel(tempResourceProvider, false, null);

		boolean tempKeepFiles = "true".equals(System.getProperty("keepFiles"));
		try {
			if (tempKeepFiles) {
				tempXmlFile = new File(getTempDir(), aSuiteName + ".xml");
			} else {
				tempXmlFile = File.createTempFile("integrityJUnit", ".xml");
			}

			TestRunnerCallback tempCallback = new CompoundTestRunnerCallback(new ConsoleTestCallback(),
					new XmlWriterTestCallback(getClass().getClassLoader(), tempXmlFile, "Integrity JUnit Testing",
							TransformHandling.NO_TRANSFORM, aCaptureConsoleFlag));

			TestRunner tempRunner = tempModel.initializeTestRunner(tempCallback, getParameterizedConstantValues(), null,
					null, null, null);
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

	protected Map<String, String> getParameterizedConstantValues() {
		return null;
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
		removeObjectIDs(aDoc.getRootElement());
		rempveStackTraces(aDoc.getRootElement());

		removeDurationsAndTimes(tempRef.getRootElement());
		removeObjectIDs(tempRef.getRootElement());
		rempveStackTraces(tempRef.getRootElement());

		ByteArrayOutputStream tempDocStream = new ByteArrayOutputStream();
		ByteArrayOutputStream tempRefStream = new ByteArrayOutputStream();

		XMLOutputter tempSerializer = new XMLOutputter(Format.getCompactFormat());
		tempSerializer.output(aDoc, tempDocStream);
		tempSerializer.output(tempRef, tempRefStream);

		boolean tempArraysEqual = Arrays.equals(tempDocStream.toByteArray(), tempRefStream.toByteArray());
		if (!tempArraysEqual) {
			System.out.println("--- Suite " + tempRootSuiteName + " failed comparison to reference data!");
			System.out.print("Reference: ");
			System.out.println(new String(tempRefStream.toByteArray(), "UTF-8"));
			System.out.print("Actual: ");
			System.out.println(new String(tempDocStream.toByteArray(), "UTF-8"));
		}

		assertTrue(tempArraysEqual);
	}

	/**
	 * Checks whether an exception that is expected to be thrown is actually thrown.
	 * 
	 * @param aRunnable
	 *            the runnable to execute
	 * @param aReferenceExceptionClass
	 *            the exception class to expect (optional)
	 * @param aReferenceMessage
	 *            the exception message to expect (optional)
	 * @param aReferenceMessagePattern
	 *            a pattern to match the message against (optional)
	 */
	protected void assertExceptionIsThrown(RunnableWithException aRunnable,
			Class<? extends Exception> aReferenceExceptionClass, String aReferenceMessage,
			Pattern aReferenceMessagePattern) {
		try {
			aRunnable.run();
		} catch (Throwable exc) {
			if (aReferenceExceptionClass != null) {
				assertTrue(aReferenceExceptionClass.isAssignableFrom(exc.getClass()));
			}
			if (aReferenceMessage != null) {
				assertEquals(aReferenceMessage, exc.getMessage());
			}
			if (aReferenceMessagePattern != null) {
				Matcher tempMatcher = aReferenceMessagePattern.matcher(exc.getMessage());
				assertTrue(tempMatcher.matches());
			}
			return;
		}

		// We expect an exception
		assertTrue("There was no exception, although one was expected", false);
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

	private void rempveStackTraces(Element anElement) throws JDOMException {
		Attribute tempTrace = anElement.getAttribute("exceptionTrace");
		if (tempTrace != null) {
			tempTrace.setValue("STACKTRACE");
		}

		for (Object tempChild : anElement.getChildren()) {
			if (tempChild instanceof Element) {
				rempveStackTraces((Element) tempChild);
			}
		}
	}

	private void clearAttribute(Element anElement, String anAttributeName) {
		Attribute tempAttr = anElement.getAttribute(anAttributeName);
		if (tempAttr != null) {
			tempAttr.setValue("");
		}
	}

	private void removeObjectIDs(Element anElement) throws JDOMException {
		for (Object tempAttributeObj : anElement.getAttributes()) {
			Attribute tempAttribute = (Attribute) tempAttributeObj;

			Matcher tempMatcher = OBJECT_ID_PATTERN.matcher(tempAttribute.getValue());
			if (tempMatcher.matches()) {
				tempAttribute.setValue(tempMatcher.group(1) + "00000000");
			}
		}

		for (Object tempChild : anElement.getChildren()) {
			if (tempChild instanceof Element) {
				removeObjectIDs((Element) tempChild);
			}
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

	/**
	 * Special runnable which declares to throw {@link Exception}.
	 * 
	 * 
	 * @author YOUR_NAME_HERE - initial API and implementation
	 * 
	 */
	public interface RunnableWithException {

		/**
		 * The actual code.
		 * 
		 * @throws Exception
		 */
		void run() throws Exception;
	}

}
