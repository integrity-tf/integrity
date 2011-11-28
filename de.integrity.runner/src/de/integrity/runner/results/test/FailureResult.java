package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;

public class FailureResult extends TestResult {

	public FailureResult(Object aResult, ValueOrEnumValue anExpectedValue, Long anExecutionTime) {
		super(aResult, anExpectedValue, anExecutionTime);
	}

}
