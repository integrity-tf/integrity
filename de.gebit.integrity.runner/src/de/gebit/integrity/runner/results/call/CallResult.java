package de.gebit.integrity.runner.results.call;

import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.runner.results.Result;

/**
 * An abstract base class for call results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class CallResult extends Result {

	private Object result;

	private VariableEntity targetVariable;

	public CallResult(Object aResult, VariableEntity aTargetVariable, Long anExecutionTime) {
		super(anExecutionTime);
		result = aResult;
		targetVariable = aTargetVariable;
	}

	public Object getResult() {
		return result;
	}

	public VariableEntity getTargetVariable() {
		return targetVariable;
	}

	public String toString() {
		if (result != null) {
			return result.toString();
		} else {
			return "(null)";
		}
	}
}
