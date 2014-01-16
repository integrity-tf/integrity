/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DecimalValueToBigDecimal extends Conversion<DecimalValue, BigDecimal> {

	@Override
	public BigDecimal convert(DecimalValue aSource, Class<? extends BigDecimal> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		return aSource.getDecimalValue();
	}

}
