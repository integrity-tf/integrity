/*******************************************************************************
 * Copyright (c) 2016 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A default Integrity conversion.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE)
public class MapToMap extends Conversion<Map, Map> {

	@SuppressWarnings("unchecked")
	@Override
	public Map convert(Map aSource, Class<? extends Map> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException {

		try {
			Map tempTargetInstance = aTargetType.newInstance();

			Class<?> tempTargetValueType = null;
			if (aTargetType.getTypeParameters().length >= 2) {
				tempTargetValueType = aTargetType.getTypeParameters()[1].getGenericDeclaration().getComponentType();
			}

			for (Entry<?, ?> tempEntry : ((Map<?, ?>) aSource).entrySet()) {
				// // find setter
				// Method tempWriteMethod = new PropertyDescriptor(tempEntry.getKey(), aTargetType).getWriteMethod();
				// if (tempWriteMethod == null || tempWriteMethod.getParameterTypes().length != 1) {
				// throw new ConversionFailedException(aSource.getClass(), aTargetType,
				// "No accessible standards-compliant setter found for '" + tempEntry.getKey() + "'");
				// }
				//
				// aTargetType.getp
				// Class<?> tempTargetType = tempWriteMethod.getParameterTypes()[0];
				// Class<?> tempParameterizedType = null;
				//
				// // See whether we can find a generic type parameter for the given target class
				// Class<?> tempClassInFocus = aTargetType;
				// while (tempClassInFocus != null) {
				// try {
				// Field tempField = tempClassInFocus.getDeclaredField(tempEntry.getKey());
				// Type tempGenericType = tempField.getGenericType();
				// if (tempGenericType instanceof ParameterizedType) {
				// Type tempInnerType = ((ParameterizedType) tempGenericType).getActualTypeArguments()[0];
				// if (tempInnerType instanceof WildcardType) {
				// if (((WildcardType) tempInnerType).getUpperBounds() == null) {
				// tempParameterizedType = null;
				// } else {
				// Type tempUpperBound = ((WildcardType) tempInnerType).getUpperBounds()[0];
				// if (tempUpperBound instanceof ParameterizedType) {
				// tempParameterizedType = (Class<?>) ((ParameterizedType) tempUpperBound)
				// .getRawType();
				// } else {
				// tempParameterizedType = (Class<?>) tempUpperBound;
				// }
				// }
				// // lower bounds not currently supported!
				//
				// } else {
				// if (tempInnerType instanceof ParameterizedType) {
				// tempParameterizedType = (Class<?>) ((ParameterizedType) tempInnerType).getRawType();
				// } else {
				// tempParameterizedType = (Class<?>) tempInnerType;
				// }
				// }
				// }
				// break;
				// } catch (SecurityException exc) {
				// // don't care, just continue
				// } catch (NoSuchFieldException exc) {
				// // don't care, just continue
				// }
				// tempClassInFocus = tempClassInFocus.getSuperclass();
				// }

				Object tempConvertedValue;
				// if (tempEntry.getValue() instanceof Map) { // map itself
				// // case for only one element within an array type
				// Class<?> tempOriginalClass = tempWriteMethod.getParameterTypes()[0];
				// Class<?> tempClass = tempOriginalClass;
				// if (tempOriginalClass.isArray()) {
				// tempClass = tempClass.getComponentType();
				// }
				//
				// tempConvertedValue = convert(((Map) tempEntry.getValue()), tempClass, aConversionContext);
				//
				// if (tempOriginalClass.isArray()) {
				// Object tempCopy = tempConvertedValue;
				// tempConvertedValue = Array.newInstance(tempClass, 1);
				// Array.set(tempConvertedValue, 0, tempCopy);
				// }
				// } else { // value
				tempConvertedValue = convertValueRecursive(tempTargetValueType, null, tempEntry.getValue(),
						aConversionContext);
				// }
				tempTargetInstance.put(tempEntry.getKey(), tempConvertedValue);
			}
			return tempTargetInstance;
		} catch (

		InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (SecurityException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}
	}

}
