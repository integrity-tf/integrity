package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValue;

public class TestComparisonUndeterminedResult extends TestComparisonResult {

	public TestComparisonUndeterminedResult(String aParameter, ValueOrEnumValue anExpectedValue) {
		super(aParameter, null, anExpectedValue);
	}
}
