/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.enums;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks very simple fixture calls.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class simpleEnumStuff extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testCalls() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/enums/simpleEnumCalls.integrity" },
				"integrity.basic.enums.simpleEnumCalls", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTests() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/enums/simpleEnumTests.integrity" },
				"integrity.basic.enums.simpleEnumTests", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTableTests() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/enums/simpleEnumTableTests.integrity" },
				"integrity.basic.enums.simpleEnumTableTests", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testEnumTableTestWithNonTableParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/enums/simpleEnumTableTests.integrity" },
				"integrity.basic.enums.enumTableTestWithNonTableParam", null);
		assertDocumentMatchesReference(tempResult);
	}

}
