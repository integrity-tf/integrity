package de.gebit.integrity.runner.results.call;

import de.gebit.integrity.dsl.VariableEntity;

public class UndeterminedResult extends CallResult {

	public UndeterminedResult(VariableEntity aTargetVariable) {
		super(null, aTargetVariable, null);
	}

}
