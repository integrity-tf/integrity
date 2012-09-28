/**
 * 
 */
package de.gebit.integrity;

import hudson.XmlFile;
import hudson.model.BuildListener;
import hudson.model.HealthReport;
import hudson.model.AbstractBuild;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.util.HeapSpaceStringConverter;
import hudson.util.XStream2;

import java.io.File;
import java.io.IOException;

import org.jvnet.localizer.Localizable;
import org.kohsuke.stapler.StaplerProxy;
import org.kohsuke.stapler.export.Exported;

import com.thoughtworks.xstream.XStream;

/**
 * This result action is responsible for displaying the test result overview on the page of individual builds.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityTestResultAction extends AbstractTestResultAction<IntegrityTestResultAction> implements
		StaplerProxy {

	/**
	 * The result to display.
	 */
	private IntegrityCompoundTestResult result;

	/**
	 * The listener.
	 */
	private transient BuildListener listener;

	/**
	 * The XStream instance used for result persistence.
	 */
	private static final XStream XSTREAM = new XStream2();

	static {
		XSTREAM.alias("result", IntegrityCompoundTestResult.class);
		XSTREAM.registerConverter(new HeapSpaceStringConverter(), 100);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param anOwner
	 *            the owning build
	 * @param aResult
	 *            the compound test result to display
	 * @param aListener
	 *            the listener
	 */
	public IntegrityTestResultAction(AbstractBuild<?, ?> anOwner, IntegrityCompoundTestResult aResult,
			BuildListener aListener) {
		super(anOwner);
		synchronized (this) {
			aResult.setOwner(owner);

			try {
				getDataFile().write(aResult);
			} catch (IOException exc) {
				exc.printStackTrace(aListener.fatalError("Failed to save the Integrity test result"));
			}

			result = aResult;
			listener = aListener;
		}
	}

	private XmlFile getDataFile() {
		return new XmlFile(XSTREAM, new File(owner.getRootDir(), "integrityResult.xml"));
	}

	private IntegrityCompoundTestResult loadFromDisk() {
		IntegrityCompoundTestResult tempResult;
		try {
			tempResult = (IntegrityCompoundTestResult) getDataFile().read();
		} catch (IOException exc) {
			exc.printStackTrace(listener.fatalError("Failed to save the Integrity test result from " + getDataFile()));
			tempResult = new IntegrityCompoundTestResult();
		}
		return tempResult;
	}

	/**
	 * Fetches the result (if necessary from disk).
	 */
	public synchronized IntegrityCompoundTestResult getResult() {
		if (result == null) {
			result = loadFromDisk();
		}

		return result;
	}

	public String getDisplayName() {
		return de.gebit.integrity.Messages.TestResultActionDisplayName();
	}

	@Exported(visibility = 2)
	public String getUrlName() {
		return "integrityReport";
	}

	public Object getTarget() {
		return result;
	}

	@Override
	public String getIconFileName() {
		if (getSkipCount() + getFailCount() == 0) {
			return "/plugin/de.gebit.integrity.jenkins/integrity_icon_success.png";
		} else {
			return "/plugin/de.gebit.integrity.jenkins/integrity_icon_failure.png";
		}
	}

	/**
	 * Returns the health report of this build, based on the result.
	 */
	public HealthReport getBuildHealth() {
		final int tempTotalCount = getTotalCount();
		final int tempFailCount = getSkipCount() + getFailCount();
		int tempScore = (tempTotalCount == 0) ? 100 : (int) (100.0 * (1.0 - ((double) tempFailCount) / tempTotalCount));
		Localizable tempDescription = null;
		if (tempTotalCount == 0) {
			tempDescription = de.gebit.integrity.Messages._NoTestResult();
		} else {
			tempDescription = de.gebit.integrity.Messages._TestResult(getFailCount(), tempTotalCount, getSkipCount());
		}
		return new HealthReport(tempScore, tempDescription);
	}

	public String getSummary() {
		return de.gebit.integrity.Messages.TestResult(getFailCount(), getTotalCount(), getSkipCount());
	}

	@Override
	@Exported(visibility = 2)
	public int getFailCount() {
		return getResult().getFailCount();
	}

	@Override
	@Exported(visibility = 2)
	public int getTotalCount() {
		return getResult().getTotalCount();
	}

	@Override
	@Exported(visibility = 2)
	public int getSkipCount() {
		return getResult().getSkipCount();
	}
}