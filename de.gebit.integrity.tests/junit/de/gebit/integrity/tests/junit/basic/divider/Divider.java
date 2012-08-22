package de.gebit.integrity.tests.junit.basic.divider;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks suite dependencies and teardowns.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class Divider extends IntegrityJUnitTest {

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
				new String[] { "integrity/suites/basic/divider/divider.integrity" }, "integrity.basic.divider.divider",
				null);
		assertDocumentMatchesReference(tempResult);
	}

}
