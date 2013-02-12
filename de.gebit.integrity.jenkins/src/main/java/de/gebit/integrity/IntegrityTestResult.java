/**
 * 
 */
package de.gebit.integrity;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * This result object encapsulates a single parsed Integrity test result file. There is a compound class which combines
 * multiple of these into one bigger result, {@link IntegrityCompoundTestResult}.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityTestResult extends TabulatedResult {

	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = 6444750573793802895L;

	/**
	 * The parent (should be an instance of {@link IntegrityCompoundTestResult}).
	 */
	private transient TestObject parent;

	/**
	 * The action owning this result.
	 */
	private transient AbstractTestResultAction<?> parentAction;

	/**
	 * The unique name of this result. The result file names are used for this purpose.
	 */
	private String name;

	/**
	 * The name displayed for this result in the overview list. Must not be unique.
	 */
	private String displayName;

	/**
	 * The content type.
	 */
	private String contentType;

	/**
	 * The raw test report XML data. Stored GZIP-compressed to save on hard disk space while persisted. Decompression
	 * and compression happen on-the-fly in the getter/setter.
	 */
	private byte[] rawData;

	/**
	 * The number of successful tests.
	 */
	private int successCount;

	/**
	 * The number of failures.
	 */
	private int failureCount;

	/**
	 * The number of test exceptions.
	 */
	private int testExceptionCount;

	/**
	 * The number of call exceptions.
	 */
	private int callExceptionCount;

	/**
	 * Creates an instance.
	 * 
	 * @param aParent
	 *            the parent
	 * @param aName
	 *            the unique name
	 * @param aDisplayName
	 *            the displayed name
	 * @param someRawData
	 *            the raw XML data
	 * @param aSuccessCount
	 *            the number of successful tests
	 * @param aFailureCount
	 *            the number of failures
	 * @param aTestExceptionCount
	 *            the number of test exceptions
	 * @param aCallExceptionCount
	 *            the number of call exceptions
	 */
	// SUPPRESS CHECKSTYLE ParameterNumber
	public IntegrityTestResult(TestObject aParent, String aName, String aDisplayName, byte[] someRawData,
			String aContentType, int aSuccessCount, int aFailureCount, int aTestExceptionCount, int aCallExceptionCount) {
		super();
		this.parent = aParent;
		this.name = aName;
		this.displayName = aDisplayName;
		setRawData(someRawData);
		this.successCount = aSuccessCount;
		this.failureCount = aFailureCount;
		this.testExceptionCount = aTestExceptionCount;
		this.callExceptionCount = aCallExceptionCount;
		this.contentType = aContentType;
	}

	@Override
	public TestObject getParent() {
		return parent;
	}

	@Override
	public AbstractBuild<?, ?> getOwner() {
		return (parentAction == null ? null : parentAction.owner);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setParentAction(AbstractTestResultAction aParentAction) {
		parentAction = aParentAction;
	}

	/**
	 * Returns the displayed name for this test.
	 */
	public String getDisplayName() {
		if (displayName != null) {
			return displayName;
		} else {
			return getName();
		}
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * The raw XML test data is decompressed on the fly before it is returned.
	 * 
	 * @return the raw uncompressed XML data
	 */
	public byte[] getRawData() {
		GZIPInputStream tempGzipStream = null;
		try {
			ByteArrayInputStream tempInputStream = new ByteArrayInputStream(rawData);
			tempGzipStream = new GZIPInputStream(tempInputStream);

			byte[] tempSizeBytes = new byte[4];
			tempGzipStream.read(tempSizeBytes);
			int tempSize = ByteBuffer.wrap(tempSizeBytes).getInt();
			if (tempSize > 1024 * 1024 * 1024) {
				// Protect against absurdly high sizes and thus the risk of OutOfMemoryExceptions
				throw new RuntimeException("Apparently illegal uncompressed size: " + tempSize);
			}
			byte[] tempUncompressedRawData = new byte[tempSize];
			int tempRead = 0;
			int tempTotalRead = 0;
			do {
				tempTotalRead += tempRead;
				tempRead = tempGzipStream.read(tempUncompressedRawData, tempTotalRead, tempUncompressedRawData.length
						- tempTotalRead);
			} while (tempRead >= 0 && tempTotalRead < tempUncompressedRawData.length);

			return tempUncompressedRawData;
		} catch (IOException exc) {
			// pretty much impossible to happen, but nevertheless...
			exc.printStackTrace();
		} finally {
			if (tempGzipStream != null) {
				try {
					tempGzipStream.close();
				} catch (IOException exc) {
					// now this is REALLY impossible to happen, and even if, well, who cares anyway...
				}
			}
		}

		return null;
	}

	/**
	 * Sets the raw data and compresses it on the fly.
	 * 
	 * @param someData
	 *            the uncompressed raw XML data
	 */
	protected void setRawData(byte[] someData) {
		try {
			ByteArrayOutputStream tempOutputStream = new ByteArrayOutputStream();
			GZIPOutputStream tempGzipStream = new GZIPOutputStream(tempOutputStream);

			// Prefix the compressed data with the uncompressed data length, in order to optimize decompression
			tempGzipStream.write(ByteBuffer.allocate(4).putInt(someData.length).array());
			tempGzipStream.write(someData);
			tempGzipStream.close();

			rawData = tempOutputStream.toByteArray();
		} catch (IOException exc) {
			// pretty much impossible to happen
			exc.printStackTrace();
		}
	}

	public int getPassCount() {
		return successCount;
	}

	public int getFailCount() {
		return failureCount;
	}

	public int getSkipCount() {
		return testExceptionCount;
	}

	public int getTestExceptionCount() {
		return testExceptionCount;
	}

	public int getCallExceptionCount() {
		return callExceptionCount;
	}

	public int getTotalCount() {
		return getPassCount() + getFailCount() + getSkipCount();
	}

	@Override
	public final TestResult findCorrespondingResult(String anId) {
		if (getId().equals(anId) || (anId == null)) {
			return this;
		} else {
			// These won't ever have children!
			return null;
		}
	}

	@Override
	public final Collection<? extends TestResult> getChildren() {
		return null;
	}

	@Override
	public final boolean hasChildren() {
		return false;
	}

	/**
	 * Returns the raw data in the form of a string.
	 * 
	 * @return the raw XML data string
	 */
	public String getRawDataString() {
		byte[] tempRawData = getRawData();
		if (tempRawData == null) {
			return null;
		} else {
			try {
				return new String(tempRawData, "UTF-8");
			} catch (UnsupportedEncodingException exc) {
				exc.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * Return the content type.
	 * 
	 * @return the content type
	 */
	public String getContentType() {
		if (contentType == null) {
			return "text/xml;charset=UTF-8";
		} else {
			return contentType;
		}
	}
}