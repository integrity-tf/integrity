/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.DateFormat;
import java.text.ParseException;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 * @param <T>
 *            the target type
 */
public abstract class AbstractDateAndTimeValueToString<T> extends Conversion<DateAndTimeValue, T> {

	/**
	 * Converts the provided {@link DateAndTimeValue} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            how unresolvable variables shall be treated
	 * @return the resulting string
	 * @throws ConversionFailedException
	 */
	protected FormattedString convertToFormattedString(DateAndTimeValue aSource,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return new FormattedString(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(
					DateUtil.convertDateAndTimeValue(aSource).getTime()));
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, FormattedString.class, null, exc);
		}
	}

}