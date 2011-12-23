package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValue;

/**
 * Comparison result for successful comparisons.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonSuccessResult extends TestComparisonResult {

	public TestComparisonSuccessResult(String aParameter, Object aResult, ValueOrEnumValue anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
