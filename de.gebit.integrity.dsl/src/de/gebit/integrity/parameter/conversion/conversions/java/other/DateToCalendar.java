/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Date;
import java.util.GregorianCalendar;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DateToCalendar extends Conversion<Date, java.util.Calendar> {

	@Override
	public java.util.Calendar convert(Date aSource, Class<? extends java.util.Calendar> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		java.util.Calendar tempCalendar = GregorianCalendar.getInstance();
		tempCalendar.setTime(aSource);
		return tempCalendar;
	}

}
