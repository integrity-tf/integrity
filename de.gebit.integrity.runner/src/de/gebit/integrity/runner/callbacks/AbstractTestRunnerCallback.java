/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks;

import java.util.Map;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.TypedNestedObject;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariable;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.runner.results.FixtureExecutionResult;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * Abstract base class for test runner callback implementation. Provides some generic functionality required by most
 * callbacks. Using this class is optional; a callback can directly inherit from {@link TestRunnerCallback} as well.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractTestRunnerCallback extends TestRunnerCallback {

	/**
	 * The value converter to use.
	 */
	@Inject
	protected ValueConverter valueConverter;

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The variable manager to use.
	 */
	@Inject
	protected VariableManager variableManager;

	/**
	 * Converts a result value (that is, a value returned by a fixture during a test or call) to a formatted string.
	 * This method uses the fixture instance, if available, to perform the conversion.
	 * 
	 * @param aResultValue
	 *            the result value to convert
	 * @param aResult
	 *            the execution result which provides access to the fixture instance and method
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            what to do with unresolvable variables
	 * @return the converted string
	 */
	protected FormattedString convertResultValueToFormattedStringGuarded(Object aResultValue,
			FixtureExecutionResult aResult, boolean aForceIntermediateMapFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (aResult.getFixtureInstance() != null) {
			return aResult.getFixtureInstance().performValueToFormattedStringConversion(aResultValue,
					aResult.getFixtureMethod(), aForceIntermediateMapFlag, anUnresolvableVariableHandlingPolicy);
		} else {
			return valueConverter.convertValueToFormattedString(aResultValue, aForceIntermediateMapFlag,
					anUnresolvableVariableHandlingPolicy);
		}
	}

	/**
	 * Converts a result value (that is, a value returned by a fixture during a test or call) to a string. This method
	 * uses the fixture instance, if available, to perform the conversion.
	 * 
	 * @param aResultValue
	 *            the result value to convert
	 * @param aResult
	 *            the execution result which provides access to the fixture instance and method
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            what to do with unresolvable variables
	 * @return the converted string
	 */
	protected String convertResultValueToStringGuarded(Object aResultValue, FixtureExecutionResult aResult,
			boolean aForceIntermediateMapFlag, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return convertResultValueToFormattedStringGuarded(aResultValue, aResult, aForceIntermediateMapFlag,
				anUnresolvableVariableHandlingPolicy).toUnformattedString();
	}

	/**
	 * Determines whether a given {@link ValueOrEnumValueOrOperationCollection} contains at least one nested object (or
	 * an equivalent map with key-value pairs).
	 * 
	 * @param aCollection
	 *            the collection to check
	 * @return true or false
	 */
	protected boolean containsNestedObject(ValueOrEnumValueOrOperationCollection aCollection) {
		if (aCollection == null) {
			return false;
		}

		if (containsNestedObject(aCollection.getValue())) {
			return true;
		} else {
			for (ValueOrEnumValueOrOperation tempValue : aCollection.getMoreValues()) {
				if (containsNestedObject(tempValue)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Determines whether a given {@link ValueOrEnumValueOrOperation} contains at least one nested object (or an
	 * equivalent map with key-value pairs).
	 * 
	 * @param aValue
	 *            the value to check
	 * @return true or false
	 */
	protected boolean containsNestedObject(Object aValue) {
		if (aValue == null) {
			return false;
		}

		if (aValue instanceof Variable) {
			return containsNestedObject(variableManager.get(((Variable) aValue).getName()));
		} else if (aValue instanceof CustomOperation) {
			try {
				return containsNestedObject(valueConverter.convertValue(null, aValue,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
			} catch (UnresolvableVariableException exc) {
				throw new ThisShouldNeverHappenException("Unresolvable variables should be resolved to null");
			} catch (UnexecutableException exc) {
				// ignored here
			}
		} else if ((aValue instanceof NestedObject) || (aValue instanceof TypedNestedObject)) {
			return true;
		} else if (aValue instanceof Map<?, ?>) {
			return true;
		}

		return false;
	}

	/**
	 * Convert a value to a string intended to be included in the textual output. This most importantly converts
	 * {@link UnresolvableVariable} instances to a "null" string.
	 * 
	 * @param aValue
	 *            the value to stringify
	 * @return the string
	 */
	protected String valueToString(Object aValue) {
		if (aValue == null || aValue == UnresolvableVariable.getInstance()) {
			return "null";
		} else {
			return aValue.toString();
		}
	}
}
