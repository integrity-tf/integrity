package de.gebit.integrity.runner.results.call;

import java.util.List;

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

	private List<UpdatedVariable> updatedVariables;

	public CallResult(List<UpdatedVariable> someUpdatedVariables, Long anExecutionTime) {
		super(anExecutionTime);
		updatedVariables = someUpdatedVariables;
	}

	public List<UpdatedVariable> getUpdatedVariables() {
		return updatedVariables;
	}

	/**
	 * An updated variable.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public static final class UpdatedVariable {

		private VariableEntity targetVariable;

		private String parameterName;

		private Object value;

		public UpdatedVariable(VariableEntity aTargetVariable, String aParameterName, Object aValue) {
			targetVariable = aTargetVariable;
			parameterName = aParameterName;
			value = aValue;
		}

		public VariableEntity getTargetVariable() {
			return targetVariable;
		}

		public String getParameterName() {
			return parameterName;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object aValue) {
			value = aValue;
		}

		public String toString() {
			if (value != null) {
				return value.toString();
			} else {
				return "(null)";
			}
		}

	}
}
