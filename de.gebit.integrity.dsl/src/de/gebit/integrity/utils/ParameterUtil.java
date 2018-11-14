/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.VariableEntity;

/**
 * A utility class for handling of test/call/suite parameters.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class ParameterUtil {

	/**
	 * Instantiates a new parameter util.
	 */
	private ParameterUtil() {
		// nothing to do
	}

	/**
	 * The "fake" name of the default parameter. This is used for unnamed parameters in maps which require a non-null
	 * key.
	 */
	public static final String DEFAULT_PARAMETER_NAME = "";

	/**
	 * A fixed result "value" object indicating that a result value actually did not even exist in the named results
	 * returned by a fixture (not even with a "null" value, which is a different kind of statement).
	 */
	public static final String INEXISTENT_VALUE = "[inexistent]";

	/**
	 * Returns a map of named result names to values acquired from a given named result container. This container is
	 * assumed to be a simple Java Bean, with accessible accessor methods useable to retrieve the values of fields. The
	 * field names are used as result names and thus keys in the map. Unreachable fields are ignored.
	 * 
	 * @param aContainer
	 *            the container instance
	 * @return the map of result names to values
	 * @throws IntrospectionException
	 *             the introspection exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	public static Map<String, Object> getValuesFromNamedResultContainer(Object aContainer)
			throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> tempResultMap = new HashMap<String, Object>();

		if (aContainer != null) {
			if (aContainer instanceof Map) {
				// This is a map - maps are assumed to directly contain arbitrary result values
				@SuppressWarnings("unchecked")
				Map<String, Object> tempMap = (Map<String, Object>) aContainer;
				for (Entry<String, Object> tempEntry : tempMap.entrySet()) {
					tempResultMap.put(tempEntry.getKey(), tempEntry.getValue());
				}
			} else {
				// This is not a map - treat it as a Java Bean object and get all the attributes
				for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainer.getClass())
						.getPropertyDescriptors()) {
					Method tempReadMethod = tempDescriptor.getReadMethod();
					if (tempReadMethod != null) {
						if (Map.class.isAssignableFrom(tempDescriptor.getPropertyType())) {
							// This is an internal map - these are assumed to be used to supply arbitrary result values
							// in addition to the normal fixed named result values
							@SuppressWarnings("unchecked")
							Map<String, Object> tempMap = (Map<String, Object>) tempReadMethod.invoke(aContainer);
							for (Entry<String, Object> tempEntry : tempMap.entrySet()) {
								tempResultMap.put(tempEntry.getKey(), tempEntry.getValue());
							}
						} else {
							tempResultMap.put(tempDescriptor.getName(), tempReadMethod.invoke(aContainer));
						}
					}
				}
			}
		}

		return tempResultMap;
	}

	/**
	 * Determines the result type by looking at a result container type for a specific result name.
	 * 
	 * @param aContainerType
	 *            the container type
	 * @param aResultName
	 *            the name of the result
	 * @return the result type
	 * @throws IntrospectionException
	 *             the introspection exception
	 */
	public static Class<?> getResultTypeFromNamedResultContainerType(Class<?> aContainerType, String aResultName)
			throws IntrospectionException {
		for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainerType).getPropertyDescriptors()) {
			if (tempDescriptor.getName().equals(aResultName)) {
				return tempDescriptor.getPropertyType();
			}
		}
		return null;
	}

	/**
	 * Determines a list of all {@link VariableEntity}s referenced in a suites' parameter list.
	 * 
	 * @param aSuite
	 * @return
	 */
	public static List<VariableEntity> getVariableEntitiesForSuiteParameters(SuiteDefinition aSuite) {
		List<VariableEntity> tempResults = new ArrayList<>(aSuite.getParameters().size());

		for (SuiteParameterDefinition tempParameter : aSuite.getParameters()) {
			tempResults.add(tempParameter.getName());
		}

		return tempResults;
	}

	/**
	 * Thrown if a variable value cannot be resolved because there's no variable map given.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class UnresolvableVariableException extends RuntimeException {

		/**
		 * Serialization version.
		 */
		private static final long serialVersionUID = -7255981207674292161L;

		/**
		 * Instantiates a new unresolvable variable exception.
		 */
		public UnresolvableVariableException() {
			super();
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 * @param aCause
		 *            the a cause
		 */
		public UnresolvableVariableException(String aMessage, Throwable aCause) {
			super(aMessage, aCause);
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 */
		public UnresolvableVariableException(String aMessage) {
			super(aMessage);
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aCause
		 *            the a cause
		 */
		public UnresolvableVariableException(Throwable aCause) {
			super(aCause);
		}

	}

}
