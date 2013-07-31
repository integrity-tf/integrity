/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.mandatoryparameters;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test checking mandatory/optional parameter handling.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class MandatoryParameters extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testCallWithAllParams() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.callWithAllParams", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testCallWithOptionalParam() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
						"integrity.basic.mandatoryParameters.callWithOptionalParam", null);
			}
		}, ValidationException.class, null, Pattern.compile(
				"Validation Error in: .*?Missing mandatory parameter\\(s\\): mandatory", Pattern.DOTALL));
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testCallWithMandatoryParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.callWithMandatoryParam", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTestWithAllParams() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.testWithAllParams", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTestWithOptionalParam() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
						"integrity.basic.mandatoryParameters.testWithOptionalParam", null);
			}
		}, ValidationException.class, null, Pattern.compile(
				"Validation Error in: .*?Missing mandatory parameter\\(s\\): mandatory", Pattern.DOTALL));
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTestWithMandatoryParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.testWithMandatoryParam", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestWithAllParams() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.tabletestWithAllParams", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestWithOptionalParam() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
						"integrity.basic.mandatoryParameters.tabletestWithOptionalParam", null);
			}
		}, ValidationException.class, null, Pattern.compile(
				"Validation Error in: .*?Missing mandatory parameter\\(s\\): mandatory", Pattern.DOTALL));
	}

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestWithMandatoryParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/mandatoryParameters/mandatoryParameters.integrity" },
				"integrity.basic.mandatoryParameters.tabletestWithMandatoryParam", null);
		assertDocumentMatchesReference(tempResult);
	}
}
