/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.test;

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
	 * The name of the parameter in which the comparison expected result was given. May be null if this was the default
	 * test result.
	 */
	private String parameter;

	/**
	 * The actual result as returned by the fixture.
	 */
	private Object result;

	/**
	 * The expected result value.
	 */
	private ValueOrEnumValueOrOperationCollection expectedValue;

	/**
	 * Creates an instance.
	 * 
	 * @param aParameter
	 *            The name of the parameter in which the comparison expected result was given. May be null if this was
	 *            the default test result.
	 * @param aResult
	 *            The actual result as returned by the fixture
	 * @param anExpectedValue
	 *            the expected result value
	 */
	public TestComparisonResult(String aParameter, Object aResult, ValueOrEnumValueOrOperationCollection anExpectedValue) {
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

	public ValueOrEnumValueOrOperationCollection getExpectedValue() {
		return expectedValue;
	}

	@Override
	public String toString() {
		if (result != null) {
			return result.toString();
		} else {
			return "(null)";
		}
	}

}
