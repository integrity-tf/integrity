/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.visibility;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

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
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/visibility/variableVisibilityFail1.integrity" },
				"integrity.basic.visibility.variables.fail1", null);
		assertDocumentMatchesReference(tempResult);
	}

}
