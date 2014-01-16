/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.sql.Timestamp;
import java.text.ParseException;

import de.gebit.integrity.dsl.DateAndTimeValue;
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
public class DateAndTimeValueToTimestamp extends Conversion<DateAndTimeValue, Timestamp> {

	@Override
	public Timestamp convert(DateAndTimeValue aSource, Class<? extends Timestamp> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		try {
			return new Timestamp(DateUtil.convertDateAndTimeValue(aSource).getTime().getTime());
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, Timestamp.class, null, exc);
		}
	}

}
