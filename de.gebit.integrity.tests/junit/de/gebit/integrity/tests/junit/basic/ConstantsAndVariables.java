/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks special cases of variables/constants.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConstantsAndVariables extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testMultiValueStringConstant() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.multiValueStringConstant", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testMultiValueMapConstant() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.multiValueMapConstant", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVariableAttributeAccessSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.variableAttributeAccessSuccess", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the exception thrown.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVariableAttributeAccessAttributeNotFound() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
						"integrity.basic.variableAttributeAccessAttributeNotFound", null);
			}
		}, RuntimeException.class,
				"Did not find readable attribute 'nonexistentParameter' in bean class de.gebit.integrity.tests.fixtures.basic.beans.SimpleTestBean",
				null);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVariableAttributeAccessNested() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.variableAttributeAccessNested", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVariableAssignment() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.variableAssignment", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testParameterizedConstantNoDef() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.parameterizedConstantNoDef", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testParameterizedConstantDef() throws ModelLoadException, IOException, JDOMException {
		parameterizedConstants.put("integrity.basic.testParameterizedConst", "foo");
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.parameterizedConstantDef", null);
		assertDocumentMatchesReference(tempResult);
		parameterizedConstants.clear();
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testParameterizedConstantDefaultNoDef() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.parameterizedConstantDefaultNoDef", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testParameterizedConstantDefaultDef() throws ModelLoadException, IOException, JDOMException {
		parameterizedConstants.put("integrity.basic.testParameterizedConstWithDefault", "foo");
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/constantsAndVariables.integrity" },
				"integrity.basic.parameterizedConstantDefaultDef", null);
		assertDocumentMatchesReference(tempResult);
		parameterizedConstants.clear();
	}

	/**
	 * Parameterized constants.
	 */
	private Map<String, String> parameterizedConstants = new HashMap<>();

	@Override
	protected Map<String, String> getParameterizedConstantValues() {
		return parameterizedConstants;
	}

}
