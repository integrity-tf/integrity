/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.regex;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks regexes.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class Regex extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testSimpleRegexTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.simpleRegexTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testRegexViaConstantTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.regexViaConstantTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testAnchoredRegexTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.anchoredRegexTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testRegexAsParameterTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.regexAsParameterTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testStringAsPatternParameterTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.stringAsPatternParameterTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testComplexRegexTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.complexRegexTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testEscapedRegexTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/regex/regex.integrity" },
				"integrity.basic.regex.escapedRegexTest", null);
		assertDocumentMatchesReference(tempResult);
	}

}
