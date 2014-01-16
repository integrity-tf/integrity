/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.strings;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class StringToCharacter extends Conversion<String, Character> {

	@Override
	public Character convert(String aSource, Class<? extends Character> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		if (aSource.length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "String '" + aSource
					+ "' does not consist of a single character.");
		}

		return aSource.charAt(0);

	}

}
