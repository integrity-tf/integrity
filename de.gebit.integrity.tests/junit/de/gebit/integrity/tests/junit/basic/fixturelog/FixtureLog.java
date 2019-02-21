/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.fixturelog;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks fixture logging.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FixtureLog extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testNoLog() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.noLog", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevel0() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevel0", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevel1() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevel1", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevel2() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevel2", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevel3() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevel3", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevel4() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevel4", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogLevelTrace() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logLevelTrace", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogWithParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logWithParam", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogWithTwoParams() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logWithTwoParams", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogWithTwoParamsButOneNotGiven() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logWithTwoParamsButOneNotGiven", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogWithArrayParam() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logWithArrayParam", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testLogOnAllChannels() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/fixturelog/fixturelog.integrity" },
				"integrity.basic.fixturelog.logOnAllChannels", null);
		assertDocumentMatchesReference(tempResult);
	}

}
