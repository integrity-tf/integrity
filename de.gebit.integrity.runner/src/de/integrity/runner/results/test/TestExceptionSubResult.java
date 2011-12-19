package de.integrity.runner.results.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class TestExceptionSubResult extends TestSubResult {

	private Exception exception;

	public TestExceptionSubResult(Exception anException, Map<String, TestComparisonResult> comparisonResults,
			Long anExecutionTime) {
		super(comparisonResults, anExecutionTime);
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
