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
 * @param <T>
 *            the target type
 * 
 */
public abstract class AbstractEnumValueToString<T> extends Conversion<EnumValue, T> {

	/**
	 * Converts the provided {@link EnumValue} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            how unresolvable variables shall be treated
	 * @return the resulting string
	 */
	protected FormattedString convertToFormattedString(EnumValue aSource,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return new FormattedString(aSource.getEnumValue().getSimpleName());
	}

}
