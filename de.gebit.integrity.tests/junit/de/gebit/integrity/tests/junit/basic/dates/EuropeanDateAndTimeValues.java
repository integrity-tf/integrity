package de.gebit.integrity.tests.junit.basic.dates;

import java.io.IOException;
import java.util.Locale;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which checks date/time fixture calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class EuropeanDateAndTimeValues extends IntegrityJUnitTest {

	/**
	 * Performs a suite which does fixture calls with date/time values and checks the resulting XML document.
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		// test with german locale, regardless of system settings
		Locale.setDefault(Locale.GERMAN);

		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/dates/europeanDateAndTimeValues.integrity" },
				"integrity.basic.dates.europeanDateAndTimeValues", null);
		assertDocumentMatchesReference(tempResult);
	}

}
