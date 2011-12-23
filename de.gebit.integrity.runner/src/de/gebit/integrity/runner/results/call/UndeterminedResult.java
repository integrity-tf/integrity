package de.gebit.integrity.runner.results.call;

import de.gebit.integrity.dsl.VariableEntity;

/**
 * Result used for undetermined calls.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class UndeterminedResult extends CallResult {

	public UndeterminedResult(VariableEntity aTargetVariable) {
		super(null, aTargetVariable, null);
	}

}
