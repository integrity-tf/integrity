/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.suitecalls;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which performs some suite call tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SimpleSuiteCalls extends IntegrityJUnitTest {

	/**
	 * Tests suites.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testSimpleSuiteCall() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/suitecalls/simpleSuiteCalls.integrity" },
				"integrity.basic.suitecalls.simpleSuiteCall", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests suites.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testSimpleSuiteCallInlined() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/suitecalls/simpleSuiteCalls.integrity" },
				"integrity.basic.suitecalls.simpleSuiteCallInlined", null);
		assertDocumentMatchesReference(tempResult);
	}

}
