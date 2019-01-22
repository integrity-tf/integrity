/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.nullability;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test checking various variants of null value tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class NullabilityAtEdit extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNonNullableCallParameterFailure() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/nullability/nullabilityAtEdit_Call.integrity" },
						"integrity.basic.nullability.nonNullableParameterFailure", null);
			}
		}, ValidationException.class, null, Pattern
				.compile("Validation Error at .*?Null value provided for non-nullable parameter!", Pattern.DOTALL));
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
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/nullability/nullabilityAtEdit_Test.integrity" },
						"integrity.basic.nullability.nonNullableParameterFailure", null);
			}
		}, ValidationException.class, null, Pattern
				.compile("Validation Error at .*?Null value provided for non-nullable parameter!", Pattern.DOTALL));
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
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/nullability/nullabilityAtEdit_TableTest1.integrity" },
						"integrity.basic.nullability.nonNullableParameterFailure", null);
			}
		}, ValidationException.class, null, Pattern
				.compile("Validation Error at .*?Null value provided for non-nullable parameter!", Pattern.DOTALL));
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
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/nullability/nullabilityAtEdit_TableTest2.integrity" },
						"integrity.basic.nullability.nonNullableParameterFailure", null);
			}
		}, ValidationException.class, null, Pattern
				.compile("Validation Error at .*?Null value provided for non-nullable parameter!", Pattern.DOTALL));
	}

}
