/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.beans;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks bean to map conversion operation and result string creation in such cases.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class BeanToMapTest extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with bean values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testBeanToMapTestEquals() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/beans/beanToMapTest.integrity" },
				"integrity.basic.beans.beanToMapTestEquals", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls with bean values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testBeanToMapTestResultConverted() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/beans/beanToMapTest.integrity" },
				"integrity.basic.beans.beanToMapTestResultConverted", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does fixture calls with bean values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testBeanToMapTestMapInVariable() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/beans/beanToMapTest.integrity" },
				"integrity.basic.beans.beanToMapTestMapInVariable", null);
		assertDocumentMatchesReference(tempResult);
	}

	// /**
	// * Performs a suite which does fixture calls with bean values and checks the resulting XML document.
	// *
	// * @throws ModelLoadException
	// * @throws IOException
	// * @throws JDOMException
	// */
	// @Test
	// public void testBeanToMapTestBeanInVariable() throws ModelLoadException, IOException, JDOMException {
	// Document tempResult = executeIntegritySuite(
	// new String[] { "integrity/suites/basic/beans/beanToMapTest.integrity" },
	// "integrity.basic.beans.beanToMapTestBeanInVariable", null);
	// assertDocumentMatchesReference(tempResult);
	// }

}
