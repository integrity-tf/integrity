package de.gebit.integrity.tests.junit.basic;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test checking various variants of null value tests.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class NullChecks extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does the fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(new String[] { "integrity/suites/basic/nullChecks.integrity" },
				"integrity.basic.nullChecks", null);
		assertDocumentMatchesReference(tempResult);
	}

}
