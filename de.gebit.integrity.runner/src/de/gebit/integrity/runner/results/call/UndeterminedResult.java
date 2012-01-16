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

	public UndeterminedResult(List<UpdatedVariable> someVariablesToUpdate) {
		super(someVariablesToUpdate, null);
	}

}
