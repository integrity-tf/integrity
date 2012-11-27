package de.gebit.integrity.runner.results.call;

import java.util.List;

import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.runner.results.FixtureExecutionResult;

/**
 * An abstract base class for call results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class CallResult extends FixtureExecutionResult {

	/**
	 * Variables updated by the call.
	 */
	private List<UpdatedVariable> updatedVariables;

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
	 *            the time taken to execute the call
	 */
	public CallResult(List<UpdatedVariable> someUpdatedVariables, FixtureWrapper<?> aFixtureInstance,
			String aFixtureMethod, Long anExecutionTime) {
		super(aFixtureInstance, aFixtureMethod, anExecutionTime);
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

		/**
		 * The variable entity that is being updated.
		 */
		private VariableEntity targetVariable;

		/**
		 * The name of the parameter (if not default parameter).
		 */
		private String parameterName;

		/**
		 * The new value.
		 */
		private Object value;

		/**
		 * Creates a new instance.
		 * 
		 * @param aTargetVariable
		 *            the variable entity that is being updated
		 * @param aParameterName
		 *            the name of the parameter
		 * @param aValue
		 *            the new value
		 */
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

		@Override
		public String toString() {
			if (value != null) {
				return value.toString();
			} else {
				return "(null)";
			}
		}

	}
}
