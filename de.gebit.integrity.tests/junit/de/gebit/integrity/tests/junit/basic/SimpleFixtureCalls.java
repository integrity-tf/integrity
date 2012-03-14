package de.gebit.integrity.tests.junit.basic;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.junit.Test;

import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.tests.junit.IntegrityJUnitTest;

public class SimpleFixtureCalls extends IntegrityJUnitTest {

	@Test
	public void test() throws ModelLoadException, IOException, JDOMException {
		Document tempResult = executeIntegritySuite("integrity.basic.simpleFixtureCalls");
		assertDocumentMatchesReference(tempResult);		
	}

}