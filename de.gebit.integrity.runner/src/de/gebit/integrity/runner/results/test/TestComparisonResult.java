/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.test;

import de.gebit.integrity.comparator.ComparisonResult;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;

/**
 * Basic class for test comparisons. A single test consists of one or more comparisons, each with an expected and actual
 * result.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class TestComparisonResult {

	/**
	 * The comparison result as determined by the {@link de.gebit.integrity.runner.comparator.ResultComparator}.
	 */
	private ComparisonResult result;

	/**
	 * The name of the parameter in which the comparison expected result was given. May be null if this was the default
	 * test result.
	 */
	private String parameter;

	/**
	 * The actual result as returned by the fixture.
	 */
	private Object actualValue;

	/**
	 * The expected result value.
	 */
	private ValueOrEnumValueOrOperationCollection expectedValue;

	/**
	 * Creates an instance.
	 * 
	 * @param aResult
	 *            The {@link ComparisonResult} as determined by the
	 *            {@link de.gebit.integrity.runner.comparator.ResultComparator}
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param anActualValue
	 *            The actual result as returned by the fixture
	 * @param anExpectedValue
	 *            the expected result value
	 */
	public TestComparisonResult(ComparisonResult aResult, String aParameter, Object anActualValue,
			ValueOrEnumValueOrOperationCollection anExpectedValue) {
		result = aResult;
		parameter = aParameter;
		actualValue = anActualValue;
		expectedValue = anExpectedValue;
	}

	public ComparisonResult getResult() {
		return result;
	}

	public String getParameter() {
		return parameter;
	}

	public Object getActualValue() {
		return actualValue;
	}

	public ValueOrEnumValueOrOperationCollection getExpectedValue() {
		return expectedValue;
	}

	@Override
	public String toString() {
		if (actualValue != null) {
			return actualValue.toString();
		} else {
			return "(null)";
		}
	}

	/**
	 * Convenience method to wrap a {@link ComparisonResult}.
	 * 
	 * @param aResult
	 *            The {@link ComparisonResult} as determined by the
	 *            {@link de.gebit.integrity.runner.comparator.ResultComparator}
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param anActualValue
	 *            The actual result as returned by the fixture
	 * @param anExpectedValue
	 *            the expected result value
	 * @return a matching instance either of {@link TestComparisonSuccessResult} or {@link TestComparisonFailureResult}
	 */
	public static TestComparisonResult wrap(ComparisonResult aResult, String aParameter, Object anActualValue,
			ValueOrEnumValueOrOperationCollection anExpectedValue) {
		if (aResult.isSuccessful()) {
			return new TestComparisonSuccessResult(aResult, aParameter, anActualValue, anExpectedValue);
		} else {
			return new TestComparisonFailureResult(aResult, aParameter, anActualValue, anExpectedValue);
		}
	}

}
