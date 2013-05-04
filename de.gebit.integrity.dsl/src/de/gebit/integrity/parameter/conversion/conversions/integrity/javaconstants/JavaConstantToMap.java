/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.javaconstants;

import java.util.Map;

import de.gebit.integrity.dsl.JavaConstantValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * This conversion converts from {@link JavaConstantValue} to any target type. Basically it reads the constant value
 * from the Java class and invokes another conversion to convert whatever was read to the desired target type.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
public class JavaConstantToMap extends AbstractJavaConstantConversion<Map> {

	@Override
	public Map convert(JavaConstantValue aSource, Class<? extends Map> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return (Map) performConversion(aSource, aTargetType, anUnresolvableVariableHandlingPolicy);
	}
}
