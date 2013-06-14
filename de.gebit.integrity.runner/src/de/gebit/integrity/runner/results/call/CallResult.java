/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.call;

import java.util.List;

import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.runner.results.FixtureExecutionResult;

/**
 * An abstract base class for call results.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * @param someExtendedResults
	 *            any extended results returned by the fixture
	 */
	public CallResult(List<UpdatedVariable> someUpdatedVariables, FixtureWrapper<?> aFixtureInstance,
			String aFixtureMethod, Long anExecutionTime, List<ExtendedResult> someExtendedResults) {
		super(aFixtureInstance, aFixtureMethod, anExecutionTime, someExtendedResults);
		updatedVariables = someUpdatedVariables;
	}

	public List<UpdatedVariable> getUpdatedVariables() {
		return updatedVariables;
	}

	/**
	 * An updated variable.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static final class UpdatedVariable {

		/**
		 * The variable entity that is being updated.
		 */
		private VariableOrConstantEntity targetVariable;

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
		public UpdatedVariable(VariableOrConstantEntity aTargetVariable, String aParameterName, Object aValue) {
			targetVariable = aTargetVariable;
			parameterName = aParameterName;
			value = aValue;
		}

		public VariableOrConstantEntity getTargetVariable() {
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
