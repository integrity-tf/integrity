/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class ObjectToMap extends Conversion<Object, Map> {

	@Override
	public Map convert(Object aSource, Class<? extends Map> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		// Using a Tree Map here for values ordered by key
		Map<String, Object> tempKeyValueMap = new TreeMap<String, Object>();

		try {
			for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aSource.getClass(), Object.class)
					.getPropertyDescriptors()) {
				Method tempReadMethod = tempDescriptor.getReadMethod();
				if (tempReadMethod != null) {
					Object tempValue = tempReadMethod.invoke(aSource);
					if (tempValue instanceof Collection) {
						Collection tempCollectionValue = (Collection) tempValue;
						List<Object> tempList = new ArrayList<Object>();
						Iterator<?> tempIterator = tempCollectionValue.iterator();
						while (tempIterator.hasNext()) {
							Object tempConvertedValue = convertValueRecursive(null, null, tempIterator.next(),
									anUnresolvableVariableHandlingPolicy);
							tempList.add(tempConvertedValue);
						}
						tempKeyValueMap.put(tempDescriptor.getName(), tempList.toArray());
					} else {
						Object tempConvertedValue = convertValueRecursive(null, null, tempValue,
								anUnresolvableVariableHandlingPolicy);
						tempKeyValueMap.put(tempDescriptor.getName(), tempConvertedValue);
					}
				}
			}
		} catch (IntrospectionException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InvocationTargetException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}

		return tempKeyValueMap;
	}
}
