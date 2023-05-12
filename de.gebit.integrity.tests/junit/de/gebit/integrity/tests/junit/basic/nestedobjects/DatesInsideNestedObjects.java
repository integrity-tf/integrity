/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.nestedobjects;

import java.io.IOException;
import java.util.Locale;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks nested objects.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DatesInsideNestedObjects extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testDatesInsideNestedObjects() throws ModelLoadException, IOException, JDOMException {
		// test with german locale, regardless of system settings
		Locale.setDefault(Locale.GERMAN);

		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/datesInsideNestedObjects.integrity" },
				"integrity.basic.nestedobjects.datesInsideNestedObjects", null);
		assertDocumentMatchesReference(tempResult);
	}

}
