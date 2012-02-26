package de.gebit.integrity.runner.results.call;

import java.util.List;

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
	 * @param anExecutionTime
	 *            the time to execute the call
	 */
	public SuccessResult(List<UpdatedVariable> someUpdatedVariables, Long anExecutionTime) {
		super(someUpdatedVariables, anExecutionTime);
	}

}
