package de.gebit.integrity.tests.junit.basic.variants;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

/**
 * JUnit test which performs some variant tests.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class VaryingConstant extends IntegrityJUnitTest {

	/**
	 * Tests constant value variation (no variant set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingConstant0() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingConstant0", null);
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests constant value variation (variant 1 set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingConstant1() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingConstant1", "var1");
		assertDocumentMatchesReference(tempResult);
	}

	/**
	 * Tests constant value variation (variant 2 set).
	 * 
	 * @throws ModelLoadException
	 * @throws IOException
	 * @throws JDOMException
	 */
	@Test
	public void testVaryingConstant2() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite(
				new String[] { "integrity/suites/basic/variants/variants.integrity" },
				"integrity.basic.variants.varyingConstant2", "var2");
		assertDocumentMatchesReference(tempResult);
	}

}
