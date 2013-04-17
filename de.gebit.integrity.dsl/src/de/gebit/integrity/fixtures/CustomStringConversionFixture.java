/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import de.gebit.integrity.string.FormattedString;

/**
 * A fixture may implement this optional interface to provide customized string conversion functionality, which will be
 * used to convert values returned by the fixture to strings to be displayed in the console or the XML result file. Note
 * that at the moment, a fixture can only influence the conversion of its own results, not the conversion of the
 * expected result given in the test script!
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface CustomStringConversionFixture {

	/**
	 * Converts the given value (which is a result value from a fixture method call) to a String.
	 * 
	 * @param aValue
	 *            the value to convert
	 * @param aFixtureMethod
	 *            the fixture method name which was called and which returned the value
	 * @return the resulting string
	 */
	FormattedString convertValueToString(Object aValue, String aFixtureMethod);

}
