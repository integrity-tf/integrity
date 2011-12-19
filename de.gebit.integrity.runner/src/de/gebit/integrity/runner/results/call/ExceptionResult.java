package de.gebit.integrity.runner.results.call;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import de.gebit.integrity.dsl.VariableEntity;

public class ExceptionResult extends CallResult {

	private Exception exception;

	public ExceptionResult(Exception anException, VariableEntity aTargetVariable, Long anExecutionTime) {
		super(null, aTargetVariable, anExecutionTime);
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
