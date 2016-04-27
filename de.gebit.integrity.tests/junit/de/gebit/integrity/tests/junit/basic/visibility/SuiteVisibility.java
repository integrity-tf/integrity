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
public class SuiteVisibility extends IntegrityJUnitTest {

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
				new String[] { "integrity/suites/basic/visibility/suiteVisibility.integrity" },
				"integrity.basic.visibility.suites.success", null);
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
	public void testFail() throws ModelLoadException, IOException, JDOMException {
		assertExceptionIsThrown(new RunnableWithException() {

			@Override
			public void run() throws Exception {
				executeIntegritySuite(
						new String[] { "integrity/suites/basic/visibility/suiteVisibilityFail.integrity" },
						"integrity.basic.visibility.suites.fail", null);
			}
		}, ModelRuntimeLinkException.class, null, Pattern.compile(
				".*?/suiteVisibilityFail.integrity:19 - Failed to resolve suite referenced in suite call 'suite privateOtherPackage'"));
	}

}
