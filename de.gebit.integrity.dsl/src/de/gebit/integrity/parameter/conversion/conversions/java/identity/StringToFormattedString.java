/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.identity;

import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.string.FormattedString;

/**
 * A default Integrity conversion. This conversion actually doesn't convert anything - it exists solely to keep strings
 * as strings by default.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class StringToFormattedString extends AbstractStringToString<FormattedString> {

	@Override
	public FormattedString convert(String aSource, Class<? extends FormattedString> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		return convertToFormattedString(aSource, aConversionContext);
	}

}
