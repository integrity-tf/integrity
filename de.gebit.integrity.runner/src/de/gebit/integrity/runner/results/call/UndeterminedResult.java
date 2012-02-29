package de.gebit.integrity.runner.results.call;

import java.util.List;

/**
 * Result used for undetermined calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class UndeterminedResult extends CallResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param someVariablesToUpdate
	 *            any variables to be updated by the call
	 */
	public UndeterminedResult(List<UpdatedVariable> someVariablesToUpdate) {
		super(someVariablesToUpdate, null);
	}

}
