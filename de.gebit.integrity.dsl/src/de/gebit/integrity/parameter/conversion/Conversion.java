/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import com.google.inject.Inject;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A {@link Conversion} defines a transformation from one type into another.
 * 
 * @param <FROM>
 *            the source type
 * @param <TO>
 *            the target type
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class Conversion<FROM extends Object, TO extends Object> {

	/**
	 * The value converter used for recursive conversion.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * This set is used for automatic endless loop protection.
	 */
	private Set<Object> visitedObjects;

	/**
	 * Performs the conversion.
	 * 
	 * @param aSource
	 *            the source object to convert
	 * @param aTargetType
	 *            TODO
	 * @param aConversionContext
	 *            controls some conversion parameters and rules; may be null if the default {@link ConversionContext}
	 *            values shall be used
	 * @return the converted object
	 * @throws ConversionFailedException
	 *             in case of conversion errors
	 */
	public abstract TO convert(FROM aSource, Class<? extends TO> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException;

	/**
	 * Add this annotation to a {@link Conversion} implementation to set the priority of this conversion. Priorities are
	 * used to determine the default conversion which is used if no target conversion is given and thus multiple
	 * conversions may be used. Highest priority wins. If none is given {@link Integer#MIN_VALUE} is assumed.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Priority {

		/**
		 * The priority. Higher is more.
		 */
		int value() default Integer.MIN_VALUE;

	}

	public void setVisitedObjects(Set<Object> someVisitedObjects) {
		visitedObjects = someVisitedObjects;
	}

	/**
	 * Recursively converts the given value to the defined target type. This method provides implicit protection against
	 * endless recursion loops.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized type in case of generics
	 * @param aValue
	 *            the value to convert
	 * @param aConversionContext
	 *            some parameters controlling the conversion (if null, a default context is used)
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	protected Object convertValueRecursive(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			ConversionContext aConversionContext) throws UnresolvableVariableException, ClassNotFoundException,
			UnexecutableException, InstantiationException {
		if ((valueConverter instanceof AbstractModularValueConverter) && visitedObjects != null) {
			return ((AbstractModularValueConverter) valueConverter).convertValue(aTargetType, aParameterizedType,
					aValue, aConversionContext, visitedObjects);
		} else {
			return valueConverter.convertValue(aTargetType, aParameterizedType, aValue, aConversionContext);
		}
	}

	/**
	 * Recursively converts the given value to a string array. This method provides implicit protection against endless
	 * recursion loops.
	 * 
	 * @param aValue
	 *            the value to convert
	 * @param aConversionContext
	 *            some parameters controlling the conversion (if null, a default context is used)
	 * @return the converted string array
	 */
	protected FormattedString[] convertValueToFormattedStringArrayRecursive(Object aValue,
			ConversionContext aConversionContext) {
		if ((valueConverter instanceof AbstractModularValueConverter) && visitedObjects != null) {
			return ((AbstractModularValueConverter) valueConverter).convertValueToStringArray(aValue,
					aConversionContext, visitedObjects);
		} else {
			return valueConverter.convertValueToFormattedStringArray(aValue, aConversionContext);
		}
	}

}
