/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.postinvocation;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks post invocation fixtures.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class PostInvocationTests extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testPostInvocationSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/postInvocation/postInvocationTests.integrity" },
				"integrity.basic.postInvocation.postInvocationSuccess", null);
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
	public void testPostInvocationFailure() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/postInvocation/postInvocationTests.integrity" },
				"integrity.basic.postInvocation.postInvocationFailure", null);
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
	public void testPostInvocationException() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/postInvocation/postInvocationTests.integrity" },
				"integrity.basic.postInvocation.postInvocationException", null);
		assertDocumentMatchesReference(tempResult);
	}

}
