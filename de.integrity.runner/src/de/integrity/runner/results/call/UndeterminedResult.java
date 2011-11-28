package de.integrity.runner.results.call;

import de.integrity.dsl.VariableEntity;

public class UndeterminedResult extends CallResult {

	public UndeterminedResult(VariableEntity aTargetVariable) {
		super(null, aTargetVariable, null);
	}

}
