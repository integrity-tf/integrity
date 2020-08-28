/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.RegexValue;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.string.FormattedString;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class RegexValueToFormattedString extends AbstractRegexValueToString<FormattedString> {

	@Override
	public FormattedString convert(RegexValue aSource, Class<? extends FormattedString> aTargetType,
			ConversionContext aConversionContext) {
		return convertToFormattedString(aSource, aConversionContext);
	}

}
