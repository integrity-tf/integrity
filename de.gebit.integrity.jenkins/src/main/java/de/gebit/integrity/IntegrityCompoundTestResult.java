/**
 * 
 */
package de.gebit.integrity;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * This test result combines multiple single test results into one. The single test results are children of this
 * compound.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityCompoundTestResult extends TabulatedResult {

	/**
	 * The serialization version.
	 */
	private static final long serialVersionUID = 5660708469068256878L;

	/**
	 * The inner test results.
	 */
	private List<IntegrityTestResult> tempChildren = new ArrayList<IntegrityTestResult>();

	/**
	 * The action owning this result.
	 */
	private transient AbstractTestResultAction<?> parentAction;

	/**
	 * Adds a child (single test result).
	 * 
	 * @param aChild
	 *            the child to add
	 */
	public void addChild(IntegrityTestResult aChild) {
		tempChildren.add(aChild);
	}

	public String getDisplayName() {
		return "Integrity Test Results";
	}

	@Override
	public TestObject getParent() {
		return null;
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

	@SuppressWarnings("rawtypes")
	@Override
	public AbstractTestResultAction getParentAction() {
		return parentAction;
	}

	@Override
	public Object getDynamic(String aToken, StaplerRequest aRequest, StaplerResponse aResponse) {
		TestResult tempResult = findCorrespondingResult(aToken);
		if (tempResult != null) {
			return tempResult;
		}
		return null;
	}

	@Override
	public TestResult findCorrespondingResult(String anId) {
		if (getId().equals(anId) || (anId == null)) {
			return this;
		} else {
			if (hasChildren()) {
				for (TestResult tempChild : getChildren()) {
					TestResult tempResult = tempChild.findCorrespondingResult(anId);
					if (tempResult != null) {
						return tempResult;
					}
				}
			}
			return null;
		}
	}

	@Override
	public boolean hasChildren() {
		return tempChildren.size() > 0;
	}

	@Override
	public Collection<? extends TestResult> getChildren() {
		return tempChildren;
	}

	@Override
	public int getFailCount() {
		if (hasChildren()) {
			int tempCount = 0;
			for (TestResult tempResult : getChildren()) {
				tempCount += tempResult.getFailCount();
			}
			return tempCount;
		}

		return super.getFailCount();
	}

	@Override
	public int getPassCount() {
		if (hasChildren()) {
			int tempCount = 0;
			for (TestResult tempResult : getChildren()) {
				tempCount += tempResult.getPassCount();
			}
			return tempCount;
		}

		return super.getPassCount();
	}

	@Override
	public int getSkipCount() {
		if (hasChildren()) {
			int tempCount = 0;
			for (TestResult tempResult : getChildren()) {
				tempCount += tempResult.getSkipCount();
			}
			return tempCount;
		}

		return super.getSkipCount();
	}

	/**
	 * Gets the counter part of this {@link TestResult} in the specified run. This basically equals the upstream
	 * function that is overridden here, but it also sets the parent action.
	 * 
	 * @return null if no such counter part exists.
	 */
	@Override
	public TestResult getResultInBuild(AbstractBuild<?, ?> aBuild) {
		AbstractTestResultAction<?> tempTestResultAction = aBuild.getAction(getParentAction().getClass());
		if (tempTestResultAction == null) {
			tempTestResultAction = aBuild.getAction(AbstractTestResultAction.class);
		}
		if (tempTestResultAction == null) {
			return null;
		} else {
			TestResult tempResult = tempTestResultAction.findCorrespondingResult(this.getId());
			if (tempResult != null) {
				tempResult.setParentAction(tempTestResultAction);
			}
			return tempResult;
		}
	}

}
