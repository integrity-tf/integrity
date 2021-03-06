/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.dates;

import java.io.IOException;
import java.util.Locale;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks date/time fixture calls.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IsoDateAndTimeValues extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with date/time values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		// test with english locale, regardless of system settings
		Locale.setDefault(Locale.ENGLISH);

		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/dates/isoDateAndTimeValues.integrity" },
				"integrity.basic.dates.isoDateAndTimeValues", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls with date/time values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testJava8() throws ModelLoadException, IOException, JDOMException {
		// test with english locale, regardless of system settings
		Locale.setDefault(Locale.ENGLISH);

		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/dates/isoDateAndTimeValues.integrity" },
				"integrity.basic.dates.isoDateAndTimeValuesWithJava8", null);
		assertDocumentMatchesReference(tempResult);
	}

}
