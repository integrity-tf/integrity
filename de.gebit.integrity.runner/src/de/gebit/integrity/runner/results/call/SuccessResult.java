package de.gebit.integrity.runner.results.call;

import java.util.List;

import de.gebit.integrity.fixtures.FixtureWrapper;

/**
 * Result for successful calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SuccessResult extends CallResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param someUpdatedVariables
	 *            variables updated by the call
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            the time to execute the call
	 */
	public SuccessResult(List<UpdatedVariable> someUpdatedVariables, FixtureWrapper<?> aFixtureInstance,
			String aFixtureMethod, Long anExecutionTime) {
		super(someUpdatedVariables, aFixtureInstance, aFixtureMethod, anExecutionTime);
	}

}
