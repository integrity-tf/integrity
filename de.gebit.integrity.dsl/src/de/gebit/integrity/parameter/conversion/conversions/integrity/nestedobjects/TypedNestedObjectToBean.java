/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.TypedNestedObject;
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
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class TypedNestedObjectToBean extends Conversion<TypedNestedObject, Object> {

	@Inject
	private ClassLoader classLoader;

	@Override
	public Object convert(TypedNestedObject aSource, Class<? extends Object> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {

		Class<? extends Object> tempTargetType;
		try {
			tempTargetType = classLoader.loadClass(aSource.getType().getType().getQualifiedName());
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}

		if (aTargetType != null && !aTargetType.isAssignableFrom(tempTargetType)) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType,
					"Failed to convert typed nested object: specified type '"
							+ aSource.getType().getType().getQualifiedName()
							+ "' cannot be cast to requested target type '" + aTargetType + "'");
		}

		try {
			return convertValueRecursive(tempTargetType, null, aSource.getNestedObject(),
					anUnresolvableVariableHandlingPolicy);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}
	}
}
