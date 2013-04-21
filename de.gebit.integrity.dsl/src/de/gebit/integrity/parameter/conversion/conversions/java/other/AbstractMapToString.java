/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormatTokenElement;
import de.gebit.integrity.string.FormatTokenElement.FormatTokenType;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.string.FormattedStringElement;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 * @param <T>
 *            the target type
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractMapToString<T> extends Conversion<Map, T> {

	/**
	 * This static map stores the nesting depth information for string formatting. It is a map in order to be multi-
	 * threading-safe, in case someone starts multiple test runner instances in one VM and runs them in parallel.
	 */
	private static Map<Thread, Integer> nestedObjectDepthMap = new Hashtable<Thread, Integer>();

	/**
	 * Converts the provided {@link Map} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            how unresolvable variables shall be treated
	 * @return the resulting string
	 */
	protected FormattedString convertToFormattedString(Map aSource,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		FormattedString tempBuffer = new FormattedString("{");
		tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE));

		Integer tempDepth = nestedObjectDepthMap.get(Thread.currentThread());
		if (tempDepth == null) {
			tempDepth = 1;
		} else {
			tempDepth++;
		}
		nestedObjectDepthMap.put(Thread.currentThread(), tempDepth);

		boolean tempFirst = true;
		for (Entry<?, ?> tempEntry : ((Map<?, ?>) aSource).entrySet()) {
			FormattedString[] tempConvertedValues = convertValueToFormattedStringArrayRecursive(tempEntry.getValue(),
					anUnresolvableVariableHandlingPolicy);

			if (!tempFirst) {
				tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE, ", "));
			}

			FormattedString tempInnerBuffer = new FormattedString();
			if (tempConvertedValues.length == 1) {
				tempInnerBuffer.add(tempConvertedValues[0]);
			} else {
				for (int i = 0; i < tempConvertedValues.length; i++) {
					if (i > 0) {
						tempInnerBuffer.add(new FormattedStringElement(", "));
					}
					tempInnerBuffer.add(tempConvertedValues[i]);
				}
			}

			tempBuffer.addMultiple(new FormatTokenElement(FormatTokenType.TAB), tempDepth);
			tempBuffer.add(tempEntry.getKey() + " = ");
			tempBuffer.add(tempInnerBuffer);
			tempFirst = false;
		}

		tempDepth--;

		tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE));
		tempBuffer.addMultiple(new FormatTokenElement(FormatTokenType.TAB), tempDepth);
		tempBuffer.add("}");

		if (tempDepth == 0) {
			nestedObjectDepthMap.remove(Thread.currentThread());
		} else {
			nestedObjectDepthMap.put(Thread.currentThread(), tempDepth);
		}

		return tempBuffer;
	}
}
