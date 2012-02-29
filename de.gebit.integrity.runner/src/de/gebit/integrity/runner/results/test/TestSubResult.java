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

	/**
	 * The comparison results, mapped by the respective parameter name.
	 */
	private Map<String, TestComparisonResult> comparisonResults;

	/**
	 * Creates a new instance.
	 * 
	 * @param someComparisonResults
	 *            the comparison results
	 * @param anExecutionTime
	 *            the time taken to execute the fixture method
	 */
	public TestSubResult(Map<String, TestComparisonResult> someComparisonResults, Long anExecutionTime) {
		super(anExecutionTime);
		this.comparisonResults = someComparisonResults;
	}

	public Map<String, TestComparisonResult> getComparisonResults() {
		return comparisonResults;
	}

	/**
	 * Whether this sub-result is yet undetermined.
	 * 
	 * @return true if undetermined, false otherwise
	 */
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

	/**
	 * Whether all comparisons performed in this sub-result have been successful.
	 * 
	 * @return true if all comparisons passed, false otherwise
	 */
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
