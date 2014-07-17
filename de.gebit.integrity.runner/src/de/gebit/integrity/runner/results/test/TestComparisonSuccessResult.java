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
 * Comparison result for successful comparisons.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestComparisonSuccessResult extends TestComparisonResult {

	/**
	 * Creates a new instance.
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
	public TestComparisonSuccessResult(ComparisonResult aResult, String aParameter, Object anActualValue,
			ValueOrEnumValueOrOperationCollection anExpectedValue) {
		super(aResult, aParameter, anActualValue, anExpectedValue);

		if (aResult == null || !aResult.isSuccessful()) {
			throw new IllegalArgumentException("Provided result must be considered 'successful'!");
		}
	}

}
