/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import de.gebit.integrity.dsl.RegexValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class RegexValueToPattern extends Conversion<RegexValue, Pattern> {

	@Override
	public Pattern convert(RegexValue aSource, Class<? extends Pattern> aTargetType,
			ConversionContext aConversionContext) {
		try {
			return convert(aSource);
		} catch (PatternSyntaxException exc) {
			throw new ConversionFailedException(RegexValue.class, Pattern.class, null, exc);
		}
	}

	public static Pattern convert(RegexValue aValue) throws PatternSyntaxException {
		return Pattern
				.compile(aValue.getRegexValue().substring(1, aValue.getRegexValue().length() - 1).replace("~~", "~"));
	}

}
