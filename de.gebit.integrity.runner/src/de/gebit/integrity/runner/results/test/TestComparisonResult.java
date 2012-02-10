package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValueCollection;

/**
 * Basic class for test comparisons. A single test consists of one or more comparisons, each with an expected and actual
 * result.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class TestComparisonResult {

	private String parameter;

	private Object result;

	private ValueOrEnumValueCollection expectedValue;

	public TestComparisonResult(String aParameter, Object aResult, ValueOrEnumValueCollection anExpectedValue) {
		parameter = aParameter;
		result = aResult;
		expectedValue = anExpectedValue;
	}

	public String getParameter() {
		return parameter;
	}

	public Object getResult() {
		return result;
	}

	public ValueOrEnumValueCollection getExpectedValue() {
		return expectedValue;
	}

	public String toString() {
		if (result != null) {
			return result.toString();
		} else {
			return "(null)";
		}
	}

}
