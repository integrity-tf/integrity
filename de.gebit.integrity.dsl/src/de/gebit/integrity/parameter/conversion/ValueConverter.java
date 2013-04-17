/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * The value converter is responsible for conversion of values during test execution and/or inside the Eclipse
 * integration.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ValueConverter {

	/**
	 * Convert a given single Integrity or Java type value to a given target type (which is always a Java type).
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aValue
	 *            the value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted object
	 */
	Object convertValue(Class<?> aTargetType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			UnexecutableException;

	/**
	 * Convert a given single Integrity or Java type value to a given target type (which is always a Java type).
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized (via generics) type attached to the given target type, if applicable - for example
	 *            if a conversion to List<Integer> is desired, the target type is List, and the parameterized type is
	 *            Integer
	 * @param aValue
	 *            the value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted object
	 */
	Object convertValue(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			UnexecutableException;

	/**
	 * Converts a given value to a String. This method is intended to be used for the output of values (for example in
	 * test results, on the console etc). In comparison to
	 * {@link #convertValueToStringArray(Object, UnresolvableVariableHandling)}, this method always returns only a
	 * single String value, concatenating arrays first if necessary.
	 * 
	 * @param aValue
	 *            the value (can be an Integrity-internal type or a plain Java Object)
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the string
	 */
	String convertValueToString(Object aValue, boolean aForceIntermediateMapFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy);

	/**
	 * Converts a given value to a formattedString. This method is intended to be used for the output of values (for
	 * example in test results, on the console etc). In comparison to
	 * {@link #convertValueToStringArray(Object, UnresolvableVariableHandling)}, this method always returns only a
	 * single String value, concatenating arrays first if necessary.
	 * 
	 * @param aValue
	 *            the value (can be an Integrity-internal type or a plain Java Object)
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the string
	 */
	FormattedString convertValueToFormattedString(Object aValue, boolean aForceIntermediateMapFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy);

	/**
	 * Converts a given value to a String array. This method is intended to be used for the output of values (for
	 * example in test results, on the console etc).
	 * 
	 * @param aValue
	 *            the value (can be an Integrity-internal type or a plain Java Object)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the string array
	 */
	String[] convertValueToStringArray(Object aValue, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy);

	/**
	 * Converts a given value to a formatted String array. This method is intended to be used for the output of values
	 * (for example in test results, on the console etc).
	 * 
	 * @param aValue
	 *            the value (can be an Integrity-internal type or a plain Java Object)
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the string array
	 */
	FormattedString[] convertValueToFormattedStringArray(Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy);
}
