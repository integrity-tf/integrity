package de.gebit.integrity.tests.junit.basic.conversions;

import java.io.IOException;
import java.util.Locale;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks date/time conversions.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class DateConversions extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with date/time values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		// test with english locale, regardless of system settings
		Locale.setDefault(Locale.ENGLISH);

		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/conversions/dateConversions.integrity" },
				"integrity.basic.conversions.dateConversions", null);
		assertDocumentMatchesReference(tempResult);
	}

}
