/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.exceptions;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks exception stuff.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AbortExceptions extends IntegrityJUnitTest {

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTestNested() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTestNested", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTestNestedWithMoreStuffBehind() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTestNestedWithMoreStuffBehind", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTableTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTableTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTableTestNested() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTableTestNested", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInTableTestNestedWithMoreStuffBehind() throws ModelLoadException, IOException,
			JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInTableTestNestedWithMoreStuffBehind", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInCall() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInCall", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInCallNested() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInCallNested", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void abortExceptionInCallNestedWithMoreStuffBehind() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/abortExceptions.integrity" },
				"integrity.basic.exceptions.abortExceptions.abortExceptionInCallNestedWithMoreStuffBehind", null);
		assertDocumentMatchesReference(tempResult);
	}

}
