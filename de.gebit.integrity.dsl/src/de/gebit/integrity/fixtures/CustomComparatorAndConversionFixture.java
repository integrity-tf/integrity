/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

/**
 * This fixture extends the {@link CustomComparatorFixture} by a means to manually determine the target type to which
 * the expected result in a test script is to be converted.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface CustomComparatorAndConversionFixture extends CustomComparatorFixture {

	/**
	 * Returns the type to which the expected result (the data given in the test script) that corresponds to the given
	 * fixture result is to be converted. By default this would be the type of the fixture result, but you may return
	 * anything else here if you desire.
	 * 
	 * @param aFixtureResult
	 *            the result value returned by the fixture call
	 * @param aMethodName
	 *            the fixture method that was called
	 * @param aPropertyName
	 *            the property name that is to be compared (null if it's the default result)
	 * @return
	 */
	Class<?> determineConversionTargetType(Object aFixtureResult, String aMethodName, String aPropertyName);

}