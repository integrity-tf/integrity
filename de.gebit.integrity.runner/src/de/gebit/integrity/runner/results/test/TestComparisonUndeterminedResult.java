package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.OperationOrValueCollection;

/**
 * Comparison result used when test comparisons are still undetermined.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonUndeterminedResult extends TestComparisonResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param anExpectedValue
	 *            The expected result value
	 */
	public TestComparisonUndeterminedResult(String aParameter, OperationOrValueCollection anExpectedValue) {
		super(aParameter, null, anExpectedValue);
	}
}
