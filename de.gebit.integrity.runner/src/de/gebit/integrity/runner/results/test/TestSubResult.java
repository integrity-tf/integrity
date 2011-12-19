package de.gebit.integrity.runner.results.test;

import java.util.Map;

import de.gebit.integrity.runner.results.Result;

public abstract class TestSubResult extends Result {

	private Map<String, TestComparisonResult> comparisonResults;

	public TestSubResult(Map<String, TestComparisonResult> comparisonResults, Long anExecutionTime) {
		super(anExecutionTime);
		this.comparisonResults = comparisonResults;
	}

	public Map<String, TestComparisonResult> getComparisonResults() {
		return comparisonResults;
	}

	public boolean isUndetermined() {
		if (comparisonResults == null) {
			return true;
		} else {
			for (TestComparisonResult tempResult : comparisonResults.values()) {
				if (tempResult instanceof TestComparisonUndeterminedResult) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean wereAllComparisonsSuccessful() {
		if (comparisonResults == null) {
			return false;
		} else {
			for (TestComparisonResult tempResult : comparisonResults.values()) {
				if (tempResult instanceof TestComparisonFailureResult) {
					return false;
				}
			}
			return true;
		}
	}

}
