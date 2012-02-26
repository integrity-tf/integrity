package de.gebit.integrity.runner.results.test;

import java.util.Map;

/**
 * A sub-result of an executed test.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestExecutedSubResult extends TestSubResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param someComparisonResults
	 *            Map of named result name to the respective comparison result
	 * @param anExecutionTime
	 *            The time taken to execute the test method
	 */
	public TestExecutedSubResult(Map<String, TestComparisonResult> someComparisonResults, Long anExecutionTime) {
		super(someComparisonResults, anExecutionTime);
	}

}
