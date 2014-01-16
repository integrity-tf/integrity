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
import de.gebit.integrity.string.FormattedString;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 * @param <T>
 *            the target type
 */
public abstract class AbstractStringValueToString<T> extends Conversion<StringValue, T> {

	/**
	 * Converts the provided {@link StringValue} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param aConversionContext
	 *            the conversion context
	 * @return the resulting string
	 */
	protected FormattedString convertToFormattedString(StringValue aSource, ConversionContext aConversionContext) {
		return new FormattedString(aSource.getStringValue());
	}

}
