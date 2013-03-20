/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class NumberToCharacter extends Conversion<Number, Character> {

	@Override
	public Character convert(Number aSource, Class<? extends Character> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		String tempString = aSource.toString();

		if (tempString.length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "Number '" + tempString
					+ "' does not consist of a single character.");
		}

		return tempString.charAt(0);
	}

}
