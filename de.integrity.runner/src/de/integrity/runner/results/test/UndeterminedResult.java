package de.integrity.runner.results.test;

import de.integrity.dsl.ValueOrEnumValue;

public class UndeterminedResult extends TestResult {

	public UndeterminedResult(ValueOrEnumValue anExpectedValue) {
		super(null, anExpectedValue, null);
	}

}
