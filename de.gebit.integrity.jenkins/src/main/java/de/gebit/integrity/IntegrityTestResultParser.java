/**
 * 
 */
package de.gebit.integrity;

import hudson.Launcher;
import hudson.model.TaskListener;
import hudson.tasks.test.DefaultTestResultParserImpl;
import hudson.tasks.test.TestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * The actual parser for parsing the Integrity result files and extraction of summary information.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityTestResultParser extends DefaultTestResultParserImpl {

	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = 4841424533054027138L;

	@Override
	protected TestResult parse(List<File> someReportFiles, Launcher aLauncher, TaskListener aListener)
			throws InterruptedException, IOException {
		final IntegrityCompoundTestResult tempCompoundTestResult = new IntegrityCompoundTestResult();

		for (File tempFile : someReportFiles) {
			aListener.getLogger().println("Now parsing Integrity test result file" + tempFile.getAbsolutePath());

			FileReader tempFileReader = null;
			try {
				// Read the file into memory. Mainly done to archive it in the result, but the buffer is also fed into
				// a SAX parser below to prevent reading the file twice.
				FileInputStream tempInputStream = new FileInputStream(tempFile);
				final byte[] tempBuffer = new byte[(int) tempFile.length()];
				try {
					int tempTotalRead = 0;
					int tempRead = 0;
					while (tempTotalRead < tempBuffer.length && tempRead >= 0) {
						tempRead = tempInputStream.read(tempBuffer, tempTotalRead, tempBuffer.length - tempTotalRead);
						if (tempRead > 0) {
							tempTotalRead += tempRead;
						}
					}
				} finally {
					tempInputStream.close();
				}

				final IntegrityContentHandler tempContentHandler = new IntegrityContentHandler();

				XMLReader tempXmlReader = XMLReaderFactory.createXMLReader();
				tempXmlReader.setContentHandler(tempContentHandler);

				InputSource tempInputSource = new InputSource(new ByteArrayInputStream(tempBuffer));

				tempXmlReader.parse(tempInputSource);

				tempCompoundTestResult.addChild(new IntegrityTestResult(tempCompoundTestResult, tempFile.getName(),
						tempContentHandler.getTestName(), tempBuffer, tempContentHandler.getSuccessCount(),
						tempContentHandler.getFailureCount(), tempContentHandler.getExceptionCount()));
			} catch (SAXException exc) {
				aListener.getLogger().println("Exception while parsing Integrity result: " + exc.getMessage());
			} finally {
				if (tempFileReader != null) {
					tempFileReader.close();
				}
			}
		}

		return tempCompoundTestResult;
	}

	private static class IntegrityContentHandler implements ContentHandler {

		/**
		 * The number of successful tests.
		 */
		private int successCount;

		/**
		 * The number of failed tests.
		 */
		private int failureCount;

		/**
		 * The number of exceptions.
		 */
		private int exceptionCount;

		/**
		 * The depth of the stack of suites at the moment.
		 */
		private int suiteStackDepth;

		/**
		 * Whether we are currently inside the XSLT script part.
		 */
		private boolean insideXslt;

		/**
		 * The name of the test run.
		 */
		private String testName;

		public int getSuccessCount() {
			return successCount;
		}

		public int getFailureCount() {
			return failureCount;
		}

		public int getExceptionCount() {
			return exceptionCount;
		}

		public String getTestName() {
			return testName;
		}

		public void setDocumentLocator(Locator aLocator) {
			// not used at the moment
		}

		public void startDocument() throws SAXException {
			// not used at the moment
		}

		public void endDocument() throws SAXException {
			// not used at the moment
		}

		public void startPrefixMapping(String aPrefix, String anUri) throws SAXException {
			// not used at the moment
		}

		public void endPrefixMapping(String aPrefix) throws SAXException {
			// not used at the moment
		}

		public void startElement(String anUri, String aLocalName, String aQualifiedName, Attributes someAttributes)
				throws SAXException {
			if (!insideXslt) {
				if ("xsl:stylesheet".equals(aQualifiedName)) {
					insideXslt = true;
					return;
				}

				if ("suite".equals(aLocalName)) {
					suiteStackDepth++;
				} else if ("integrity".equals(aLocalName)) {
					testName = someAttributes.getValue("name");
				} else if ("result".equals(aLocalName)) {
					if (suiteStackDepth == 1 && someAttributes.getValue("type") == null) {
						// This seems to be the outermost suite result element (call results are also <result> elements,
						// but
						// they contain a result type instead of a summary). We simply fetch the execution totals from
						// this
						// one and rely on Integrity for summing them up correctly.

						String tempSuccessCount = someAttributes.getValue("successCount");
						if (tempSuccessCount != null) {
							successCount = Integer.parseInt(tempSuccessCount);
						}

						String tempFailureCount = someAttributes.getValue("failureCount");
						if (tempFailureCount != null) {
							failureCount = Integer.parseInt(tempFailureCount);
						}

						String tempExceptionCount = someAttributes.getValue("exceptionCount");
						if (tempExceptionCount != null) {
							exceptionCount = Integer.parseInt(tempExceptionCount);
						}
					}
				}
			}
		}

		public void endElement(String anUri, String aLocalName, String aQualifiedName) throws SAXException {
			if (insideXslt) {
				if ("xsl:stylesheet".equals(aQualifiedName)) {
					insideXslt = false;
				}
			} else {
				if ("suite".equals(aLocalName)) {
					suiteStackDepth--;
				}
			}
		}

		public void characters(char[] someCharacters, int aStart, int aLength) throws SAXException {
			// not used at the moment
		}

		public void ignorableWhitespace(char[] someCharacters, int aStart, int aLength) throws SAXException {
			// not used at the moment
		}

		public void processingInstruction(String aTarget, String aData) throws SAXException {
			// not used at the moment
		}

		public void skippedEntity(String aName) throws SAXException {
			// not used at the moment
		}
	}

}
