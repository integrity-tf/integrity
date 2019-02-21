/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Optional;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.ParameterUtil;

/**
 * This conversion is necessary to allow {@link Optional}s to be displayed correctly in test results. For actual value
 * comparison, the value comparator will already handle Optional resolution, because for that job, non-present optionals
 * must be handled in a special way.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE + 1)
public class OptionalToFormattedString extends Conversion<Optional, FormattedString> {

	@Override
	public FormattedString convert(Optional aSource, Class<? extends FormattedString> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		if (aSource.isPresent()) {
			return (FormattedString) convertValueToFormattedStringArrayRecursive(aSource.get(), aConversionContext)[0];
		} else {
			return new FormattedString(ParameterUtil.INEXISTENT_VALUE);
		}
	}

}
