/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.sql.Date;
import java.util.Calendar;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * 
 * @author Heinz Serfas - initial API and implementation
 * 
 */
public class CalendarToSQLDate extends Conversion<Calendar, Date> {

	@Override
	public Date convert(Calendar aSource, Class<? extends Date> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException {
		return new Date(aSource.getTime().getTime());
	}

}
