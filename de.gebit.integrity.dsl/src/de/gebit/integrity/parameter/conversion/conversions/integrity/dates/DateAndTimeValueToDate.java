/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Date;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DateAndTimeValueToDate extends Conversion<DateAndTimeValue, Date> {

	@Override
	public Date convert(DateAndTimeValue aSource, Class<? extends Date> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateAndTimeValue(aSource).getTime();
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, Date.class, null, exc);
		}
	}

}
