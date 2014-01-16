/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class StringValueToCharacter extends Conversion<StringValue, Character> {

	@Override
	public Character convert(StringValue aSource, Class<? extends Character> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		if (aSource.getStringValue() == null || aSource.getStringValue().length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "String '" + aSource.getStringValue()
					+ "' does not consist of a single character.");
		}

		return aSource.getStringValue().charAt(0);
	}

}
