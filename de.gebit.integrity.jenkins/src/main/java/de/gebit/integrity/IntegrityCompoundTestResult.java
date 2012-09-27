/**
 * 
 */
package de.gebit.integrity;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TabulatedResult;
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
	private static final long serialVersionUID = 5660708449068256878L;

	/**
	 * The inner test results.
	 */
	private List<IntegrityTestResult> tempChildren = new ArrayList<IntegrityTestResult>();

	/**
	 * The owner.
	 */
	private AbstractBuild<?, ?> owner;

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
		return owner;
	}

	/**
	 * Sets the owner. This also sets the owner of all children.
	 * 
	 * @param anOwner
	 *            the new owner
	 */
	public void setOwner(AbstractBuild<?, ?> anOwner) {
		owner = anOwner;
		for (IntegrityTestResult tempChild : tempChildren) {
			tempChild.setOwner(anOwner);
		}
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

}
