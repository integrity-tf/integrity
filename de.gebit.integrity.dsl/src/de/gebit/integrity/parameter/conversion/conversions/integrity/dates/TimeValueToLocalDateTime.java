/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import de.gebit.integrity.dsl.TimeValue;
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
public class TimeValueToLocalDateTime extends Conversion<TimeValue, LocalDateTime> {

	@Override
	public LocalDateTime convert(TimeValue aSource, Class<? extends LocalDateTime> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		try {
			return LocalDateTime.from(DateUtil.convertTimeValue(aSource).toInstant().atZone(ZoneId.systemDefault()));
		} catch (ParseException exc) {
			throw new ConversionFailedException(TimeValue.class, Date.class, null, exc);
		}
	}

}
