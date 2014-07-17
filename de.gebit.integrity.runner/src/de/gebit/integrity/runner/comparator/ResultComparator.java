/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.comparator;

import de.gebit.integrity.comparator.ComparisonResult;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.UnexecutableException;

/**
 * The result comparator is used to compare a result object returned by a fixture instance with a given expected result
 * (from the test script).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ResultComparator {

	/**
	 * Compares the expected result with the actual result obtained from a test fixture.
	 * 
	 * @param aFixtureResult
	 *            the test fixture result
	 * @param anExpectedResult
	 *            the expected result as specified in the test script
	 * @param aFixtureInstance
	 *            the fixture instance that was used
	 * @param aFixtureMethod
	 *            the fixture method that was called
	 * @param aPropertyName
	 *            the name of the result property to be compared (null if it's the default result)
	 * @return true if the comparison was successful, false if the results are not considered equal
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	ComparisonResult compareResult(Object aFixtureResult, ValueOrEnumValueOrOperationCollection anExpectedResult,
			FixtureWrapper<?> aFixtureInstance, MethodReference aFixtureMethod, String aPropertyName)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

}
