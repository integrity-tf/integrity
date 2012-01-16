package de.gebit.integrity.runner.results.call;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * The result returned if a call resulted in an exception.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ExceptionResult extends CallResult {

	private Exception exception;

	public ExceptionResult(Exception anException, List<UpdatedVariable> someVariablesToUpdate, Long anExecutionTime) {
		super(someVariablesToUpdate, anExecutionTime);
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
