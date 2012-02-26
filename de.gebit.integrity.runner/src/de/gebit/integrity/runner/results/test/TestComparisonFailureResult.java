package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValueCollection;

/**
 * Comparison result for failed test comparisons.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonFailureResult extends TestComparisonResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param aResult
	 *            the actual result object
	 * @param anExpectedValue
	 *            the expected value
	 */
	public TestComparisonFailureResult(String aParameter, Object aResult, ValueOrEnumValueCollection anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
