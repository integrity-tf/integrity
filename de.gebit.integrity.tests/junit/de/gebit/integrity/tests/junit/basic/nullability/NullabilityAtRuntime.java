/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.nullability;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test checking various variants of null value tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class NullabilityAtRuntime extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNonNullableCallParameterSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableCallParameterSuccess", null);
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
	public void testNonNullableCallParameterFailure() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableCallParameterFailure", null);
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
	public void testNonNullableTestParameterSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableTestParameterSuccess", null);
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
	public void testNonNullableTestParameterFailure() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableTestParameterFailure", null);
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
	public void testNonNullableTableTestParameterSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableTableTestParameterSuccess", null);
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
	public void testNonNullableTableTestParameterFailure1() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableTableTestParameterFailure1", null);
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
	public void testNonNullableTableTestParameterFailure2() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableTableTestParameterFailure1", null);
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
	public void testNonNullableCallArrayParameterSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableCallArrayParameterSuccess", null);
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
	public void testNonNullableCallArrayParameterFailure() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nullability/nullabilityAtRuntime.integrity" },
				"integrity.basic.nullability.nonNullableCallArrayParameterFailure", null);
		assertDocumentMatchesReference(tempResult);
	}

}
