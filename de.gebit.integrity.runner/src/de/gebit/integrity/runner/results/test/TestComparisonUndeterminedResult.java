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
 * Comparison result used when test comparisons are still undetermined.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
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
	public TestComparisonUndeterminedResult(String aParameter, ValueOrEnumValueOrOperationCollection anExpectedValue) {
		super(aParameter, null, anExpectedValue);
	}
}
