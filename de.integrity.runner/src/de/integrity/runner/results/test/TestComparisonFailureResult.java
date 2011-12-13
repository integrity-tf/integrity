package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;

public class TestComparisonFailureResult extends TestComparisonResult {

	public TestComparisonFailureResult(String aParameter, Object aResult, ValueOrEnumValue anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
