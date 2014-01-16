/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.sql.Date;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SQLDateToTimestamp extends Conversion<Date, java.sql.Timestamp> {

	@Override
	public java.sql.Timestamp convert(Date aSource, Class<? extends java.sql.Timestamp> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		return new java.sql.Timestamp(aSource.getTime());
	}

}
