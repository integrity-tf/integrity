/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.string.FormattedStringElement;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class MapToString extends Conversion<Map, FormattedString> {

	@Override
	public FormattedString convert(Map aSource, Class<? extends FormattedString> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		FormattedString tempBuffer = new FormattedString("{");

		for (Entry<?, ?> tempEntry : ((Map<?, ?>) aSource).entrySet()) {
			FormattedString[] tempConvertedValues = convertValueToFormattedStringArrayRecursive(tempEntry.getValue(),
					anUnresolvableVariableHandlingPolicy);

			if (tempBuffer.getElementCount() > 1) {
				tempBuffer.add(", ");
			}

			FormattedString tempInnerBuffer = new FormattedString();
			if (tempConvertedValues.length == 1) {
				tempInnerBuffer.add(tempConvertedValues[0]);
			} else {
				tempInnerBuffer.add("[");
				for (int i = 0; i < tempConvertedValues.length; i++) {
					if (i > 0) {
						tempInnerBuffer.add(new FormattedStringElement(", "));
					}
					tempInnerBuffer.add(tempConvertedValues[i]);
				}
				tempInnerBuffer.add("]");
			}

			tempBuffer.add(tempEntry.getKey() + "=");
			tempBuffer.add(tempInnerBuffer);
		}

		tempBuffer.add("}");

		return tempBuffer;
	}
}
