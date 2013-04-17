/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormattedString;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class EnumValueToString extends Conversion<EnumValue, FormattedString> {

	@Override
	public FormattedString convert(EnumValue aSource, Class<? extends FormattedString> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return new FormattedString(aSource.getEnumValue().getSimpleName());
	}

}
