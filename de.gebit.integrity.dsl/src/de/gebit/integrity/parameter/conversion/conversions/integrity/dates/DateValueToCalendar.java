/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class DateValueToCalendar extends Conversion<DateValue, Calendar> {

	@Override
	public Calendar convert(DateValue aSource, Class<? extends Calendar> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		try {
			return DateUtil.convertDateValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, Calendar.class, null, exc);
		}
	}

}
