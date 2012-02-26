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

	/**
	 * Creates a new instance.
	 * 
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param aResult
	 *            The actual result as returned by the fixture
	 * @param anExpectedValue
	 *            The expected result value
	 */
	public TestComparisonSuccessResult(String aParameter, Object aResult, ValueOrEnumValueCollection anExpectedValue) {
		super(aParameter, aResult, anExpectedValue);
	}

}
