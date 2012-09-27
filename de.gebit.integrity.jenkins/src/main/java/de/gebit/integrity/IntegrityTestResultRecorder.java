package de.gebit.integrity;

import hudson.AbortException;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.tasks.junit.Messages;
import hudson.util.FormValidation;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

/**
 * The result recorder for Integrity test results. This is the main class of the Integrity Test Result plugin - this
 * class is plugged into the Jenkins as a custom result recorder.
 * 
 * @author Rene Schneider
 */
public class IntegrityTestResultRecorder extends Recorder {

	/**
	 * The file name pattern string.
	 */
	private final String testResultFileNamePattern;

	/**
	 * Creates a new instance.
	 * 
	 * @param aTestResultFileNamePattern
	 *            the result file name pattern to use
	 */
	@DataBoundConstructor
	public IntegrityTestResultRecorder(String aTestResultFileNamePattern) {
		this.testResultFileNamePattern = aTestResultFileNamePattern;
	}

	public String getTestResults() {
		return testResultFileNamePattern;
	}

	public BuildStepMonitor getRequiredMonitorService() {
		return BuildStepMonitor.NONE;
	}

	@Override
	public DescriptorImpl getDescriptor() {
		return (DescriptorImpl) super.getDescriptor();
	}

	@Override
	public Collection<Action> getProjectActions(AbstractProject<?, ?> aProject) {
		// SUPPRESS CHECKSTYLE Whitespace
		return Collections.<Action> singleton(new IntegrityProjectAction(aProject));
	}

	@Override
	public boolean perform(AbstractBuild<?, ?> aBuild, Launcher aLauncher, BuildListener aListener)
			throws InterruptedException, IOException {
		aListener.getLogger().println("Recording Integrity Test Results");
		IntegrityTestResultAction tempResultAction;

		final String tempExpandedTestResults = aBuild.getEnvironment(aListener).expand(this.testResultFileNamePattern);

		try {
			IntegrityCompoundTestResult tempResult = (IntegrityCompoundTestResult) new IntegrityTestResultParser()
					.parse(tempExpandedTestResults, aBuild, aLauncher, aListener);

			try {
				tempResultAction = new IntegrityTestResultAction(aBuild, tempResult, aListener);
			} catch (NullPointerException exc) {
				throw new AbortException(Messages.JUnitResultArchiver_BadXML(testResultFileNamePattern));
			}
			if (tempResult.getTotalCount() == 0) {
				throw new AbortException("Integrity Test Result is empty!");
			}
		} catch (AbortException exc) {
			if (aBuild.getResult() == Result.FAILURE) {
				return true;
			}

			aListener.getLogger().println(exc.getMessage());
			aBuild.setResult(Result.FAILURE);
			return true;
		} catch (IOException exc) {
			exc.printStackTrace(aListener.error("Failed to archive test reports"));
			aBuild.setResult(Result.FAILURE);
			return true;
		}

		aBuild.getActions().add(tempResultAction);

		if (tempResultAction.getResult().getFailCount() > 0 || tempResultAction.getResult().getSkipCount() > 0) {
			aBuild.setResult(Result.UNSTABLE);
		}

		return true;
	}

	/**
	 * This descriptor is used to integrate the {@link IntegrityTestResultRecorder} as a post-build step into Jenkins.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	@Extension
	public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

		/**
		 * Creates an instance.
		 */
		public DescriptorImpl() {
			load();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean isApplicable(Class<? extends AbstractProject> aJobType) {
			return true;
		}

		@Override
		public String getDisplayName() {
			return "Publish Integrity Test Results";
		}

		/**
		 * Performs on-the-fly validation on the file mask wildcard.
		 */
		@SuppressWarnings("rawtypes")
		public FormValidation doCheckTestResults(@AncestorInPath AbstractProject aProject, @QueryParameter String aValue)
				throws IOException {
			return FilePath.validateFileMask(aProject.getSomeWorkspace(), aValue);
		}

	}

}
