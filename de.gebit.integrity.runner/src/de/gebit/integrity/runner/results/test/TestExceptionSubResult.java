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

	/**
	 * The exception that occurred.
	 */
	private Exception exception;

	/**
	 * Creates a new instance.
	 * 
	 * @param anException
	 *            The exception that occurred
	 * @param aComparisonResult
	 *            Map of result names to the respective comparison
	 * @param anExecutionTime
	 *            Time taken to execute the test method
	 */
	public TestExceptionSubResult(Exception anException, Map<String, TestComparisonResult> aComparisonResult,
			Long anExecutionTime) {
		super(aComparisonResult, anExecutionTime);
		exception = anException;
	}

	@Override
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
