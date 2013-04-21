/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Map;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.string.FormatTokenElement;
import de.gebit.integrity.string.FormatTokenElement.FormatTokenType;
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
public abstract class AbstractNestedObjectToString<T> extends Conversion<NestedObject, T> {

	/**
	 * This static map stores the nesting depth information for string formatting. It is a map in order to be multi-
	 * threading-safe, in case someone starts multiple test runner instances in one VM and runs them in parallel.
	 */
	private static Map<Thread, Integer> nestedObjectDepthMap = new Hashtable<Thread, Integer>();

	/**
	 * Converts the provided {@link NestedObject} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            how unresolvable variables shall be treated
	 * @return the resulting string
	 * @throws ConversionFailedException
	 */
	protected FormattedString convertToFormattedString(NestedObject aSource,
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
		for (KeyValuePair tempAttribute : aSource.getAttributes()) {
			Object tempConvertedValue;
			try {
				tempConvertedValue = convertValueRecursive(FormattedString[].class, null, tempAttribute.getValue(),
						anUnresolvableVariableHandlingPolicy);
			} catch (ClassNotFoundException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (UnexecutableException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (InstantiationException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			}

			if (!tempFirst) {
				tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE, ", "));
			}

			FormattedString tempConvertedValueStringBuffer = new FormattedString();

			if (tempConvertedValue == null) {
				tempConvertedValueStringBuffer.add("null");
			} else {
				int tempArrayLength = Array.getLength(tempConvertedValue);
				for (int i = 0; i < tempArrayLength; i++) {
					if (i > 0) {
						tempConvertedValueStringBuffer.add(", ");
					}
					Object tempSingleArrayValue = Array.get(tempConvertedValue, i);
					if (tempSingleArrayValue instanceof FormattedString) {
						tempConvertedValueStringBuffer.add((FormattedString) tempSingleArrayValue);
					} else {
						tempConvertedValueStringBuffer.add(tempSingleArrayValue != null ? tempSingleArrayValue
								.toString() : "null");
					}
				}
			}

			tempBuffer.addMultiple(new FormatTokenElement(FormatTokenType.TAB), tempDepth);
			tempBuffer.add(tempAttribute.getIdentifier() + " = ");
			tempBuffer.add(tempConvertedValueStringBuffer);
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
