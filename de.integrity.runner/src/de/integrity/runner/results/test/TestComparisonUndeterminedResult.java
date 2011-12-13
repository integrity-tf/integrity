package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;

public class TestComparisonUndeterminedResult extends TestComparisonResult {

	public TestComparisonUndeterminedResult(String aParameter, ValueOrEnumValue anExpectedValue) {
		super(aParameter, null, anExpectedValue);
	}
}
