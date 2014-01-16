/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE)
public class NestedObjectToBean extends Conversion<NestedObject, Object> {

	@Override
	public Object convert(NestedObject aSource, Class<? extends Object> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {

		if (aTargetType == null) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType,
					"Cannot convert nested object to non-Map object if the target type is not specified!");
		} else if (aTargetType == Object.class) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType,
					"Cannot convert untyped nested object to bean if no specific target class is given, either by "
							+ "using typed nested objects or by providing the class as target type in the "
							+ "corresponding fixture parameter!");
		}

		try {
			Object tempTargetInstance = aTargetType.newInstance();

			for (KeyValuePair tempAttribute : aSource.getAttributes()) {
				Method tempWriteMethod = new PropertyDescriptor(
						IntegrityDSLUtil.getIdentifierFromKeyValuePair(tempAttribute), aTargetType).getWriteMethod();
				if (tempWriteMethod == null || tempWriteMethod.getParameterTypes().length != 1) {
					throw new ConversionFailedException(aSource.getClass(), aTargetType,
							"No accessible standards-compliant setter found for '"
									+ IntegrityDSLUtil.getIdentifierFromKeyValuePair(tempAttribute) + "'");
				}

				Class<?> tempTargetType = tempWriteMethod.getParameterTypes()[0];
				Class<?> tempParameterizedType = null;

				// See whether we can find a generic type parameter for the given target class
				Class<?> tempClassInFocus = aTargetType;
				while (tempClassInFocus != null) {
					try {
						Field tempField = tempClassInFocus.getDeclaredField(IntegrityDSLUtil
								.getIdentifierFromKeyValuePair(tempAttribute));
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

				Object tempConvertedValue = convertValueRecursive(tempTargetType, tempParameterizedType,
						tempAttribute.getValue(), aConversionContext);
				tempWriteMethod.invoke(tempTargetInstance, new Object[] { tempConvertedValue });
			}

			return tempTargetInstance;
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IntrospectionException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InvocationTargetException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}
	}
}
