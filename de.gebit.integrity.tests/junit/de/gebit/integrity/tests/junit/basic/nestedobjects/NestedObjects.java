package de.gebit.integrity.tests.junit.basic.nestedobjects;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks nested objects.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class NestedObjects extends IntegrityJUnitTest {

	/**
	 * Performs the test.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/nestedobjects/nestedobjects.integrity" },
				"integrity.basic.nestedobjects.nestedobjects", null);
		assertDocumentMatchesReference(tempResult);
	}

}
