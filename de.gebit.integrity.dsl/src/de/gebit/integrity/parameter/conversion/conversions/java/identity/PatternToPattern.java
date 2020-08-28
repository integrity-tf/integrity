/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.identity;

import java.util.regex.Pattern;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion. This conversion actually doesn't convert anything - it just returns the input. This
 * special conversion is not part of the normal bunch of conversions which is scanned to find a matching one, but only
 * used to handle special cases.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class PatternToPattern extends Conversion<Pattern, Pattern> {

	@Override
	public Pattern convert(Pattern aSource, Class<? extends Pattern> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException {
		return aSource;
	}

}
