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

import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DateValueToString extends Conversion<DateValue, FormattedString> {

	@Override
	public FormattedString convert(DateValue aSource, Class<? extends FormattedString> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return new FormattedString(DateFormat.getDateInstance(DateFormat.LONG).format(
					DateUtil.convertDateValue(aSource).getTime()));
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, FormattedString.class, null, exc);
		}
	}

}
