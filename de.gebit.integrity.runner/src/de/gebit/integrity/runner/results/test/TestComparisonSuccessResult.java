package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValueCollection;

/**
 * Comparison result for successful comparisons.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonSuccessResult extends TestComparisonResult {

	public TestComparisonSuccessResult(String aParameter, Object aResult, ValueOrEnumValueCollection anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
