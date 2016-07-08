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
import java.util.SortedMap;
import java.util.TreeMap;

import de.gebit.integrity.comparator.MapComparisonResult;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
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
	 * The property in the {@link ConversionContext} used to transport the path in the map.
	 */
	protected static final String MAP_PATH_PROPERTY = "path";

	/**
	 * Converts the provided {@link Map} to a {@link FormattedString}.
	 * 
	 * @param aSource
	 *            the source value
	 * @param aConversionContext
	 *            the conversion context
	 * @return the resulting string
	 */
	protected FormattedString convertToFormattedString(Map<?, ?> aSource, ConversionContext aConversionContext)
			throws ConversionFailedException {
		String tempParentMapPath = (String) aConversionContext.getProperty(MAP_PATH_PROPERTY);

		FormattedString tempBuffer = new FormattedString("{");
		tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE));

		Integer tempDepth = nestedObjectDepthMap.get(Thread.currentThread());
		if (tempDepth == null) {
			tempDepth = 1;
		} else {
			tempDepth++;
		}
		nestedObjectDepthMap.put(Thread.currentThread(), tempDepth);

		// In order to provide a consistent ordering of map entries in the string, we want to sort the map by natural
		// key ordering
		SortedMap<?, ?> tempSortedSource = null;
		if (aSource instanceof SortedMap) {
			// Either our source map is already sorted...
			tempSortedSource = (SortedMap) aSource;
		} else {
			// ...or we need to sort it by creating a TreeMap and filling it
			tempSortedSource = new TreeMap<>(aSource);
		}

		try {
			boolean tempFirst = true;
			for (Entry<?, ?> tempEntry : ((Map<?, ?>) tempSortedSource).entrySet()) {
				String tempCurrentMapPath = (tempParentMapPath != null ? tempParentMapPath + "." : "")
						+ tempEntry.getKey();
				aConversionContext.withProperty(MAP_PATH_PROPERTY, tempCurrentMapPath);

				boolean tempCurrentPathFailed = (aConversionContext
						.getComparisonResult() instanceof MapComparisonResult)
						&& ((MapComparisonResult) aConversionContext.getComparisonResult()).getFailedPaths()
								.contains(tempCurrentMapPath);

				FormattedString[] tempConvertedValues = convertValueToFormattedStringArrayRecursive(
						tempEntry.getValue(), aConversionContext);

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
				if (tempCurrentPathFailed) {
					tempBuffer.add(new FormatTokenElement(FormatTokenType.UNDERLINE_START));
					tempBuffer.add(new FormatTokenElement(FormatTokenType.BOLD_START));
				}
				tempBuffer.add(tempEntry.getKey() + " = ");
				tempBuffer.add(tempInnerBuffer);
				if (tempCurrentPathFailed) {
					tempBuffer.add(new FormatTokenElement(FormatTokenType.BOLD_END));
					tempBuffer.add(new FormatTokenElement(FormatTokenType.UNDERLINE_END));
				}
				tempFirst = false;
			}
		} finally {
			tempDepth--;

			tempBuffer.add(new FormatTokenElement(FormatTokenType.NEWLINE));
			tempBuffer.addMultiple(new FormatTokenElement(FormatTokenType.TAB), tempDepth);
			tempBuffer.add("}");

			if (tempDepth == 0) {
				nestedObjectDepthMap.remove(Thread.currentThread());
			} else {
				nestedObjectDepthMap.put(Thread.currentThread(), tempDepth);
			}
		}

		return tempBuffer;
	}
}
