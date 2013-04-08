/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A default Integrity conversion.
 * 
 * 
 * @author Heinz Serfas - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE)
public class MapToBean extends Conversion<Map, Object> {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Map aSource, Class<? extends Object> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {

		try {
			Object tempTargetInstance = aTargetType.newInstance();

			for (Entry<String, ?> tempEntry : ((Map<String, ?>) aSource).entrySet()) {
				// find setter
				Method tempWriteMethod = new PropertyDescriptor(tempEntry.getKey(), aTargetType).getWriteMethod();
				if (tempWriteMethod == null || tempWriteMethod.getParameterTypes().length != 1) {
					throw new ConversionFailedException(aSource.getClass(), aTargetType,
							"No accessible standards-compliant setter found for '" + tempEntry.getKey() + "'");
				}

				Class<?> tempTargetType = tempWriteMethod.getParameterTypes()[0];
				Class<?> tempParameterizedType = null;

				// See whether we can find a generic type parameter for the given target class
				Class<?> tempClassInFocus = aTargetType;
				while (tempClassInFocus != null) {
					try {
						Field tempField = tempClassInFocus.getDeclaredField(tempEntry.getKey());
						Type tempGenericType = tempField.getGenericType();
						if (tempGenericType instanceof ParameterizedType) {
							Type tempInnerType = ((ParameterizedType) tempGenericType).getActualTypeArguments()[0];
							if (tempInnerType instanceof WildcardType) {
								if (((WildcardType) tempInnerType).getUpperBounds() == null) {
									tempParameterizedType = null;
								} else {
									Type tempUpperBound = ((WildcardType) tempInnerType).getUpperBounds()[0];
									if (tempUpperBound instanceof ParameterizedType) {
										tempParameterizedType = (Class<?>) ((ParameterizedType) tempUpperBound)
												.getRawType();
									} else {
										tempParameterizedType = (Class<?>) tempUpperBound;
									}
								}
								// lower bounds not currently supported!

							} else {
								if (tempInnerType instanceof ParameterizedType) {
									tempParameterizedType = (Class<?>) ((ParameterizedType) tempInnerType).getRawType();
								} else {
									tempParameterizedType = (Class<?>) tempInnerType;
								}
							}
						}
						break;
					} catch (SecurityException exc) {
						// don't care, just continue
					} catch (NoSuchFieldException exc) {
						// don't care, just continue
					}
					tempClassInFocus = tempClassInFocus.getSuperclass();
				}

				Object tempConvertedValue;
				if (tempEntry.getValue() instanceof Map) { // map itself
					// case for only one element within an array type
					Class<?> tempOriginalClass = tempWriteMethod.getParameterTypes()[0];
					Class<?> tempClass = tempOriginalClass;
					if (tempOriginalClass.isArray()) {
						tempClass = tempClass.getComponentType();
					}

					tempConvertedValue = convert(((Map) tempEntry.getValue()), tempClass,
							anUnresolvableVariableHandlingPolicy);

					if (tempOriginalClass.isArray()) {
						Object tempCopy = tempConvertedValue;
						tempConvertedValue = Array.newInstance(tempClass, 1);
						Array.set(tempConvertedValue, 0, tempCopy);
					}
				} else { // value
					tempConvertedValue = convertValueRecursive(tempTargetType, tempParameterizedType,
							tempEntry.getValue(), anUnresolvableVariableHandlingPolicy);
				}
				tempWriteMethod.invoke(tempTargetInstance, new Object[] { tempConvertedValue });
			}
			return tempTargetInstance;
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IntrospectionException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InvocationTargetException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (SecurityException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}
	}

}
