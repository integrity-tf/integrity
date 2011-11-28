package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;

public class SuccessResult extends TestResult {

	public SuccessResult(Object aResult, ValueOrEnumValue anExpectedValue, Long anExecutionTime) {
		super(aResult, anExpectedValue, anExecutionTime);
	}

}
