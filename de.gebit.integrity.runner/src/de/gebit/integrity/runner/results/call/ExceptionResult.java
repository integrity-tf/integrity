package de.gebit.integrity.runner.results.call;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

import de.gebit.integrity.fixtures.FixtureWrapper;

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
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            the time it took to execute the call
	 */
	public ExceptionResult(Throwable anException, List<UpdatedVariable> someVariablesToUpdate,
			FixtureWrapper<?> aFixtureInstance, String aFixtureMethod, Long anExecutionTime) {
		super(someVariablesToUpdate, aFixtureInstance, aFixtureMethod, anExecutionTime);
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
