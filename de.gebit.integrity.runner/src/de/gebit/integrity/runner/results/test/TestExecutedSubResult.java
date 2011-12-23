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

	public TestExecutedSubResult(Map<String, TestComparisonResult> someComparisonResults, Long anExecutionTime) {
		super(someComparisonResults, anExecutionTime);
	}

}
