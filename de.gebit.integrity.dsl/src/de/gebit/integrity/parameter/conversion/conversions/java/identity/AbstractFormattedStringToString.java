/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.identity;

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
 */
public abstract class AbstractFormattedStringToString<T> extends Conversion<FormattedString, T> {

	/**
	 * Converts nothing ;-).
	 * 
	 * @param aSource
	 *            the source value
	 * @param aConversionContext
	 *            the conversion context
	 * @return the resulting string
	 */
	protected FormattedString convertToFormattedString(FormattedString aSource, ConversionContext aConversionContext)
			throws ConversionFailedException {
		return aSource;
	}

}
