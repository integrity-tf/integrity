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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A utility class for handling of test/call parameters.
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
			for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainer.getClass())
					.getPropertyDescriptors()) {
				Method tempReadMethod = tempDescriptor.getReadMethod();
				if (tempReadMethod != null) {
					if (Map.class.isAssignableFrom(tempDescriptor.getPropertyType())) {
						// this is a map for arbitrary result names
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
