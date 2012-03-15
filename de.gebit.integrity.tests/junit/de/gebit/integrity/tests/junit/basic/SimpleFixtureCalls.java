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
public class SimpleFixtureCalls extends IntegrityJUnitTest {

	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite("integrity.basic.simpleFixtureCalls");
		assertDocumentMatchesReference(tempResult);
	}

}
