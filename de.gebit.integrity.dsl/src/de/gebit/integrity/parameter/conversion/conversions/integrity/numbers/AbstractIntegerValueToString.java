/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.string.FormattedString;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 * @param <T>
 *            the target type
 * 
 */
public abstract class AbstractIntegerValueToString<T> extends Conversion<IntegerValue, T> {

	/**
	 * Converts the provided {@link IntegerValue} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param aConversionContext
	 *            the conversion context
	 * @return the resulting string
	 * @throws ConversionFailedException
	 */
	protected FormattedString convertToFormattedString(IntegerValue aSource, ConversionContext aConversionContext)
			throws ConversionFailedException {
		return new FormattedString(aSource.getIntegerValue().toString());
	}

}
