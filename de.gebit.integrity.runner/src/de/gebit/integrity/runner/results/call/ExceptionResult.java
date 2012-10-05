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

	/**
	 * The exception that was thrown.
	 */
	private Throwable exception;

	/**
	 * Creates a new instance.
	 * 
	 * @param anException
	 *            the exception that was thrown
	 * @param someVariablesToUpdate
	 *            the variables that were to be updated
	 * @param anExecutionTime
	 *            the time it took to execute the call
	 */
	public ExceptionResult(Throwable anException, List<UpdatedVariable> someVariablesToUpdate, Long anExecutionTime) {
		super(someVariablesToUpdate, anExecutionTime);
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

	public Throwable getException() {
		return exception;
	}

}
