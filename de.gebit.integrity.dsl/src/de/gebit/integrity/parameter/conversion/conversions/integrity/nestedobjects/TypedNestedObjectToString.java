/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import de.gebit.integrity.dsl.TypedNestedObject;
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
public class TypedNestedObjectToString extends Conversion<TypedNestedObject, String> {

	@Override
	public String convert(TypedNestedObject aSource, Class<? extends String> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		// For string conversions, the defined target type in a typed nested object is ignored, since it's not relevant
		try {
			return (String) convertValueRecursive(aTargetType, null, aSource.getNestedObject(), aConversionContext);
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
