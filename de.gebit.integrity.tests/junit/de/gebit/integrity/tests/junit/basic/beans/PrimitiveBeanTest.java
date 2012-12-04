package de.gebit.integrity.tests.junit.basic.beans;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks bean calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class PrimitiveBeanTest extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with bean values and checks the
	 * resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/beans/primitiveBeanTest.integrity" },
				"integrity.basic.beans.primitiveBeanTest", null);
		assertDocumentMatchesReference(tempResult);
	}

}
