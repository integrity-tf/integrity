package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValue;

/**
 * Comparison result used when test comparisons are still undetermined.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestComparisonUndeterminedResult extends TestComparisonResult {

	public TestComparisonUndeterminedResult(String aParameter, ValueOrEnumValue anExpectedValue) {
		super(aParameter, null, anExpectedValue);
	}
}
