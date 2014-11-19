/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.visibility;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which performs some variable visibility tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class VariableVisibility extends IntegrityJUnitTest {

	/**
	 * Tests successful references.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testSuccess() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/visibility/variableVisibility.integrity" },
				"integrity.basic.visibility.variables.success", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests failing references.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testFail1() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(
				new RunnableWithException() {

					@Override
					public void run() throws Exception {
						executeIntegritySuite(
								new String[] { "integrity/suites/basic/visibility/variableVisibilityFail1.integrity" },
								"integrity.basic.visibility.variables.fail1", null);
					}
				}, ModelRuntimeLinkException.class, null,
				Pattern.compile(".*?/variableVisibilityFail1.integrity:13 - Failed to resolve variable name"));
	}

	/**
	 * Tests failing references.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testFail2() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(
				new RunnableWithException() {

					@Override
					public void run() throws Exception {
						executeIntegritySuite(
								new String[] { "integrity/suites/basic/visibility/variableVisibilityFail2.integrity" },
								"integrity.basic.visibility.variables.fail2", null);
					}
				}, ModelRuntimeLinkException.class, null,
				Pattern.compile(".*?/variableVisibilityFail2.integrity:13 - Failed to resolve variable name"));
	}

	/**
	 * Tests failing references.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testFail3() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(
				new RunnableWithException() {

					@Override
					public void run() throws Exception {
						executeIntegritySuite(
								new String[] { "integrity/suites/basic/visibility/variableVisibilityFail3.integrity" },
								"integrity.basic.visibility.variables.fail3", null);
					}
				}, ModelRuntimeLinkException.class, null,
				Pattern.compile(".*?/variableVisibilityFail3.integrity:15 - Failed to resolve variable name"));
	}

}
