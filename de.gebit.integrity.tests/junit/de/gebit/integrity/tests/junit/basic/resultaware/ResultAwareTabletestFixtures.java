/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.resultaware;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Assert;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.fixtures.basic.ResultAwareNoOpFixture;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks result aware fixtures.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ResultAwareTabletestFixtures extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestNothing() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/resultAware/resultAwareTabletestFixtures.integrity" },
				"integrity.basic.resultAware.resultAwareTabletestNothing", null);
		assertDocumentMatchesReference(tempResult);

		Assert.assertArrayEquals(new String[] { "DEFAULT" }, ResultAwareNoOpFixture.getAnnouncedResults("echoBool"));
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestDefault() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/resultAware/resultAwareTabletestFixtures.integrity" },
				"integrity.basic.resultAware.resultAwareTabletestDefault", null);
		assertDocumentMatchesReference(tempResult);

		Assert.assertArrayEquals(new String[] { "DEFAULT" }, ResultAwareNoOpFixture.getAnnouncedResults("echoBool"));
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestArbitrary() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/resultAware/resultAwareTabletestFixtures.integrity" },
				"integrity.basic.resultAware.resultAwareTabletestArbitrary", null);
		assertDocumentMatchesReference(tempResult);

		Assert.assertArrayEquals(new String[] { "string1", "string2" },
				ResultAwareNoOpFixture.getAnnouncedResults("echoStringsArbitrary"));
	}

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testTabletestFixed() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/resultAware/resultAwareTabletestFixtures.integrity" },
				"integrity.basic.resultAware.resultAwareTabletestFixed", null);
		assertDocumentMatchesReference(tempResult);

		Assert.assertArrayEquals(new String[] { "string1", "string2" },
				ResultAwareNoOpFixture.getAnnouncedResults("echoStringsFixed"));
	}

}
