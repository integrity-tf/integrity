/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.booleans;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class BooleanValueToString extends AbstractBooleanValueToString<String> {

	@Override
	public String convert(BooleanValue aSource, Class<? extends String> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		return convertToString(aSource, aConversionContext);
	}
}
