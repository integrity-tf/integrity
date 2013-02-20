package de.gebit.integrity.tests.junit.basic.comments;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks title comments.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TitleComments extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does use comments with links and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/comments/titleComments.integrity" },
				"integrity.basic.comments.titleComments", null);
		assertDocumentMatchesReference(tempResult);
	}

}
