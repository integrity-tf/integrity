package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.dsl.ValueOrEnumValue;

public abstract class TestComparisonResult {

	private String parameter;

	private Object result;

	private ValueOrEnumValue expectedValue;

	public TestComparisonResult(String aParameter, Object aResult, ValueOrEnumValue anExpectedValue) {
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

	public ValueOrEnumValue getExpectedValue() {
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
