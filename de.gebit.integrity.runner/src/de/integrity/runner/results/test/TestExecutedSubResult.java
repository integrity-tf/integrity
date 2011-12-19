package de.integrity.runner.results.test;

import java.util.Map;

public class TestExecutedSubResult extends TestSubResult {

	public TestExecutedSubResult(Map<String, TestComparisonResult> comparisonResults, Long anExecutionTime) {
		super(comparisonResults, anExecutionTime);
	}

}
