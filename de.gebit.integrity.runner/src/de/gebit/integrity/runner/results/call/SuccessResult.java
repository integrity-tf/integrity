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

	public SuccessResult(List<UpdatedVariable> someUpdatedVariables, Long anExecutionTime) {
		super(someUpdatedVariables, anExecutionTime);
	}

}
