/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.arbitraryparameters;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks arbitrary parameters.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ArbitraryParameters extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with arbitrary parameters and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/arbitraryParameters/arbitraryParameters.integrity" },
				"integrity.basic.arbitraryParameters.arbitraryParameters", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls with arbitrary parameters and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testBeans() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/arbitraryParameters/arbitraryParameters.integrity" },
				"integrity.basic.arbitraryParameters.arbitraryParametersAndBeans", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls with arbitrary parameters and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testStringIdentifiers() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/arbitraryParameters/arbitraryParameters.integrity" },
				"integrity.basic.arbitraryParameters.arbitraryParametersWithStringIdentifiers", null);
		assertDocumentMatchesReference(tempResult);
	}

}
