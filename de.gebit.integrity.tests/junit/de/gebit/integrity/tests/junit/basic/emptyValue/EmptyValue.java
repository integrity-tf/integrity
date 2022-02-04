/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.emptyValue;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks empty values.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class EmptyValue extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testEmptyList() throws ModelLoadException, IOException, JDOMException {
		Document tempResult
				= executeIntegritySuite(new String[] { "integrity/suites/basic/emptyValue/emptyValue.integrity" },
						"integrity.basic.emptyValue.emptyListTest", null);
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
	public void testEmptyArray() throws ModelLoadException, IOException, JDOMException {
		Document tempResult
				= executeIntegritySuite(new String[] { "integrity/suites/basic/emptyValue/emptyValue.integrity" },
						"integrity.basic.emptyValue.emptyArrayTest", null);
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
	public void testEmptyListWrapped() throws ModelLoadException, IOException, JDOMException {
		Document tempResult
				= executeIntegritySuite(new String[] { "integrity/suites/basic/emptyValue/emptyValue.integrity" },
						"integrity.basic.emptyValue.emptyListWrappedTest", null);
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
	public void testEmptyArrayWrapped() throws ModelLoadException, IOException, JDOMException {
		Document tempResult
				= executeIntegritySuite(new String[] { "integrity/suites/basic/emptyValue/emptyValue.integrity" },
						"integrity.basic.emptyValue.emptyArrayWrappedTest", null);
		assertDocumentMatchesReference(tempResult);
	}

}
