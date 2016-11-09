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
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
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
	public Map convert(Object aSource, Class<? extends Map> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException {
		// Using a Tree Map here for values ordered by key
		Map<String, Object> tempKeyValueMap = new TreeMap<String, Object>();

		try {
			for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aSource.getClass(), Object.class)
					.getPropertyDescriptors()) {

				if (Boolean.TRUE.equals(tempDescriptor.getValue("transient"))) {
					// Skip transient properties, as those are often used as "fake" properties in order to implement a
					// getter for them which does some sort of magic. Calling unknown magical stuff in a generic fashion
					// when running over Java Beans is not such a good idea and quickly leads to problems, which is the
					// reason why transient properties are skipped here. See also issue #109.
					continue;
				}

				Method tempReadMethod = tempDescriptor.getReadMethod();
				if (tempReadMethod != null) {
					Object tempValue = tempReadMethod.invoke(aSource);
					if (tempValue instanceof Collection) {
						Collection tempCollectionValue = (Collection) tempValue;
						List<Object> tempList = new ArrayList<Object>();
						Iterator<?> tempIterator = tempCollectionValue.iterator();
						while (tempIterator.hasNext()) {
							Object tempConvertedValue = convertValueRecursive(null, null, tempIterator.next(),
									aConversionContext);
							tempList.add(tempConvertedValue);
						}

						// In the Integrity language, there is no difference between an array of nested objects with
						// just one object and a single nested object. The array just comes into existence by specifying
						// more than one object, separated by commas. Therefore, when converting bean objects to maps
						// (for comparison with nested object structures specified in the test script), we have to omit
						// the array object when converting collections with just one entry: the single entry must be
						// inserted directly into the map and not be wrapped into an array of size 1. Fixes issue #125.
						if (tempList.size() == 1) {
							tempKeyValueMap.put(tempDescriptor.getName(), tempList.get(0));
						} else {
							tempKeyValueMap.put(tempDescriptor.getName(), tempList.toArray());
						}
					} else {
						Object tempConvertedValue = convertValueRecursive(null, null, tempValue, aConversionContext);
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

	// protected boolean isTransient(String aFieldName, Class<?> aClass) {
	// Class<?> tempClassInFocus = aClass;
	// while(tempClassInFocus != null) {
	// try {
	// Field tempField = tempClassInFocus.getDeclaredField(aFieldName);
	//
	// if(tempField != null) {
	// return tempField.getModifiers() & Modifier
	// }
	// } catch (NoSuchFieldException | SecurityException exc) {
	// // ignore
	// }
	// }
	// }
}
