package de.gebit.integrity.tests.junit.basic;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks very simple fixture calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SpecificDescriptions extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does simple fixture calls and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/specificDescriptions.integrity" },
				"integrity.basic.specificDescriptions", null);
		assertDocumentMatchesReference(tempResult);
	}

}
