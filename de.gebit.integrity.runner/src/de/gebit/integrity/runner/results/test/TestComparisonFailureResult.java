package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValue;

/**
 * Comparison result for failed test comparisons.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonFailureResult extends TestComparisonResult {

	public TestComparisonFailureResult(String aParameter, Object aResult, ValueOrEnumValue anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
