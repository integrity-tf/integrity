package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.runner.results.Result;

public abstract class TestResult extends Result {

	private Object result;

	private ValueOrEnumValue expectedValue;

	public TestResult(Object aResult, ValueOrEnumValue anExpectedValue, Long anExecutionTime) {
		super(anExecutionTime);
		result = aResult;
		expectedValue = anExpectedValue;
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
