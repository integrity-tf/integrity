/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.variants;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which performs some variant tests.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class VaryingSuite extends IntegrityJUnitTest {

	/**
	 * Tests suite execution variation (no variant set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingSuite0() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingSuite0", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests suite execution variation (variant 1 set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingSuite1() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingSuite1", "var1");
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests suite execution variation (variant 2 set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingSuite2() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingSuite2", "var2");
		assertDocumentMatchesReference(tempResult);
	}

}
