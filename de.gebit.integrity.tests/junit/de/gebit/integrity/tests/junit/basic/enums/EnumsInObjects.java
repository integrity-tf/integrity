/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.junit.basic.enums;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * Tests enum conversion in objects.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class EnumsInObjects extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testEnumsInObjects() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/enums/enumsInObjects.integrity" },
				"integrity.basic.enums.enumsInObjects", null);
		assertDocumentMatchesReference(tempResult);
	}

}
