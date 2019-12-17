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
public class CollectionsOfNestedObjects extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testCollectionsOfNestedObjectsSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.collectionsOfNestedObjectsSuccess", null);
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
	public void testCollectionsOfNestedObjectsFailure() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.collectionsOfNestedObjectsFailure", null);
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
	public void testCollectionsOfNestedObjectsIncomplete() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.collectionsOfNestedObjectsIncomplete", null);
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
	public void testCollectionsOfNestedObjectsSingleEntry() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.collectionsOfNestedObjectsSingleEntry", null);
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
	public void testCollectionsOfNestedObjectsSingleEntryFailure()
			throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.collectionsOfNestedObjectsSingleEntryFailure", null);
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
	public void testSingleComplexObjectInsideArrayInComplexObject()
			throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.singleComplexObjectInsideArrayInComplexObject", null);
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
	public void testListOfMaps() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.listOfMaps", null);
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
	public void testListOfMapsWithSingleEntry() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/collectionsOfNestedObjects.integrity" },
				"integrity.basic.nestedobjects.listOfMapsWithSingleEntry", null);
		assertDocumentMatchesReference(tempResult);
	}

}
