/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

import de.gebit.integrity.dsl.EnumValue;
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
@SuppressWarnings("rawtypes")
public class StringValueToEnumConstant extends Conversion<StringValue, Enum> {

	@Override
	public Enum convert(StringValue aSource, Class<? extends Enum> aTargetType, ConversionContext aConversionContext) {
		if (Enum.class.isAssignableFrom(aTargetType)) {
			for (Enum tempConstant : aTargetType.getEnumConstants()) {
				if (tempConstant.toString().equals(aSource.getStringValue())) {
					return tempConstant;
				}
			}
			throw new ConversionFailedException(EnumValue.class, aTargetType, "Constant value '"
					+ aSource.getStringValue() + "' not found in enum class '" + aTargetType.getName() + "'");
		}
		throw new ConversionFailedException(EnumValue.class, aTargetType, "Class '" + aTargetType.getName()
				+ "' is not an enum");
	}

}
