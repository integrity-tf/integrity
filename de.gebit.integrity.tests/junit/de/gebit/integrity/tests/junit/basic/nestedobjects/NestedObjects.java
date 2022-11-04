/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.nestedobjects;

import java.io.IOException;

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
public class NestedObjects extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNestedObject() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjects", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNestedObjectWithOperation() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjectsWithOperations", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNestedObjectIncomplete() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjectsIncomplete", null);
		assertDocumentMatchesReference(tempResult);
	}
	
	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNestedObjectWithListsNeedingConversion() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjectsWithListsNeedingConversion", null);
		assertDocumentMatchesReference(tempResult);
	}
	
	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNestedObjectWithListsOfMaps() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjectsWithListsOfMaps", null);
		assertDocumentMatchesReference(tempResult);
	}

}
