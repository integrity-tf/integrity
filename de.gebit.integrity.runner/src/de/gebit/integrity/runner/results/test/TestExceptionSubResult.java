package de.gebit.integrity.runner.results.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;

/**
 * This result is returned if an exception occurred during test execution.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestExceptionSubResult extends TestSubResult {

	private Exception exception;

	public TestExceptionSubResult(Exception anException, Map<String, TestComparisonResult> aComparisonResult,
			Long anExecutionTime) {
		super(aComparisonResult, anExecutionTime);
		exception = anException;
	}

	public String toString() {
		ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
		PrintWriter tempWriter = new PrintWriter(tempOut);
		exception.printStackTrace(tempWriter);
		tempWriter.close();

		return "ExceptionResult: " + tempOut;
	}

	public Exception getException() {
		return exception;
	}

}
