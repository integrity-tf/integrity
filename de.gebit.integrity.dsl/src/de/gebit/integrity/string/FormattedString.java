/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.gebit.integrity.string.FormattedStringElement.FormatFlag;

/**
 * Represents a String with formatting instructions. Each formatted string consists of a number of
 * {@link AbstractFormattedStringElement}s and can be transformed in a standard {@link String} either with or without
 * the formatting instructions. If formatting info is included in that {@link String}, this is done by adding the
 * {@value #FORMATTED_STRING_START_TOKEN} at the start of the string to inform any reader that there are formatting
 * tokens to be found. These formatting tokens start with '[', followed by a token name, followed optionally by '|' plus
 * a replacement string value (to be inserted into the string instead of the token if the formatting info is to be
 * stripped from the string instead of being interpreted), and finally closed by ']'.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FormattedString {

	/**
	 * This token starts a formatted string.
	 */
	public static final String FORMATTED_STRING_START_TOKEN = "[FORMATTED]";

	/**
	 * Contains the elements that the formatted string consists of.
	 */
	protected List<AbstractFormattedStringElement> elements = new ArrayList<AbstractFormattedStringElement>();

	/**
	 * Creates a new, empty formatted string.
	 */
	public FormattedString() {

	}

	/**
	 * Creates a new formatted string with one plaintext element.
	 * 
	 * @param aText
	 *            the new string content
	 */
	public FormattedString(String aText) {
		elements.add(new FormattedStringElement(aText));
	}

	/**
	 * Creates a new formatted string with one text element, to which the provided format flags are added.
	 * 
	 * @param aText
	 *            the new string content
	 * @param someFlags
	 *            the format flags to apply to the string content
	 */
	public FormattedString(String aText, FormatFlag... someFlags) {
		elements.add(new FormattedStringElement(aText, someFlags));
	}

	/**
	 * Creates a new formatted string with the supplied elements.
	 * 
	 * @param someElements
	 *            the elements to add to the string
	 */
	public FormattedString(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	/**
	 * Adds the element to the formatted string. Elements are always added at the end.
	 * 
	 * @param anElement
	 *            the element to be added
	 */
	public void add(AbstractFormattedStringElement anElement) {
		if (anElement != null) {
			elements.add(anElement);
		}
	}

	/**
	 * Adds the provided element multiple times to the formatted string. The element is NOT cloned, but the same
	 * instance is added multiple times.
	 * 
	 * @param anElement
	 *            the element to be added
	 * @param aNumber
	 *            the number of times that the element is to be added
	 */
	public void addMultiple(AbstractFormattedStringElement anElement, int aNumber) {
		for (int i = 0; i < aNumber; i++) {
			add(anElement);
		}
	}

	/**
	 * Adds a plaintext element without formatting flags to the formatted string.
	 * 
	 * @param aString
	 *            the text for the plaintext element
	 */
	public void add(String aString) {
		elements.add(new FormattedStringElement(aString));
	}

	/**
	 * Adds a text element with the provided formatting flags to the formatted string.
	 * 
	 * @param aString
	 *            the text for the element
	 * @param someFlags
	 *            the formatting flags to apply
	 */
	public void add(String aString, FormatFlag... someFlags) {
		elements.add(new FormattedStringElement(aString, someFlags));
	}

	/**
	 * Adds the provided elements to the formatted string.
	 * 
	 * @param someElements
	 *            the elements to add
	 */
	public void add(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	/**
	 * Adds all elements of the provided formatted string to this formatted string.
	 * 
	 * @param aFormattedString
	 *            the formatted string whose elements are to be added
	 */
	public void add(FormattedString aFormattedString) {
		if (aFormattedString != null) {
			elements.addAll(aFormattedString.elements);
		} else {
			elements.add(new FormattedStringElement(null));
		}
	}

	/**
	 * Adds multiple plaintext elements without formatting flags to the formatted string.
	 * 
	 * @param someStrings
	 *            the strings to add as plaintext elements
	 */
	public void add(String... someStrings) {
		for (String tempString : someStrings) {
			elements.add(new FormattedStringElement(tempString));
		}
	}

	/**
	 * Serializes the formatted string elements into a single string with formatting tags embedded.
	 * 
	 * @return the string with formatting tags
	 */
	public String toFormattedString() {
		if (elements.size() == 0) {
			return "null";
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.toFormattedString());
		}

		String tempString = tempBuffer.toString();
		if (tempString.length() == 0 || !tempString.contains("[")) {
			return tempString;
		} else {
			return FORMATTED_STRING_START_TOKEN + tempString;
		}
	}

	/**
	 * Serializes the formatted string elements into a single string without any formatting tags.
	 * 
	 * @return the string without formatting tags
	 */
	public String toUnformattedString() {
		if (elements.size() == 0) {
			return "null";
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.toUnformattedString());
		}

		return tempBuffer.toString();
	}

	public int getElementCount() {
		return elements.size();
	}

	@Override
	public String toString() {
		return toUnformattedString();
	}

	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof FormattedString)) {
			return false;
		}

		return elements.equals(((FormattedString) anOtherObject).elements);
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

}
