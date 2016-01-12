/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.exceptions;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks exception stuff.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class CheckpointTests extends IntegrityJUnitTest {

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void simpleCheckpointTest() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/checkpointTests.integrity" },
				"integrity.basic.exceptions.checkpointTests.simpleCheckpointTest", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Performs a test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void checkpointTestNested() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/exceptions/checkpointTests.integrity" },
				"integrity.basic.exceptions.checkpointTests.checkpointTestNested", null);
		assertDocumentMatchesReference(tempResult);
	}

}
