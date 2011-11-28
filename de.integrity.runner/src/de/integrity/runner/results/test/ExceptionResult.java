package de.integrity.runner.results.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import de.integrity.dsl.ValueOrEnumValue;

public class ExceptionResult extends TestResult {

	private Exception exception;

	public ExceptionResult(Exception anException, ValueOrEnumValue anExpectedValue, Long anExecutionTime) {
		super(null, anExpectedValue, anExecutionTime);
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
