package de.gebit.integrity.runner.results.test;

import java.util.Map;

import de.gebit.integrity.runner.results.Result;

/**
 * Tests have one or more sub-results, with standard tests always having one, but tabletests potentially having more of
 * them, one for each row.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class TestSubResult extends Result {

	private Map<String, TestComparisonResult> comparisonResults;

	public TestSubResult(Map<String, TestComparisonResult> someComparisonResults, Long anExecutionTime) {
		super(anExecutionTime);
		this.comparisonResults = someComparisonResults;
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
