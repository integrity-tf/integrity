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
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FormattedString {

	public static final String FORMATTED_STRING_START_TOKEN = "[FORMATTED]";

	protected List<AbstractFormattedStringElement> elements = new ArrayList<AbstractFormattedStringElement>();

	public FormattedString() {

	}

	public FormattedString(String aText) {
		elements.add(new FormattedStringElement(aText));
	}

	public FormattedString(String aText, FormatFlag... someFlags) {
		elements.add(new FormattedStringElement(aText, someFlags));
	}

	public FormattedString(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	public void add(AbstractFormattedStringElement anElement) {
		if (anElement != null) {
			elements.add(anElement);
		}
	}

	public void addMultiple(AbstractFormattedStringElement anElement, int aNumber) {
		for (int i = 0; i < aNumber; i++) {
			add(anElement);
		}
	}

	public void add(String aString) {
		elements.add(new FormattedStringElement(aString));
	}

	public void add(String aString, FormatFlag... someFlags) {
		elements.add(new FormattedStringElement(aString, someFlags));
	}

	public void add(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	public void add(FormattedString aFormattedString) {
		if (aFormattedString != null) {
			elements.addAll(aFormattedString.elements);
		} else {
			elements.add(new FormattedStringElement(null));
		}
	}

	public void add(String... someStrings) {
		for (String tempString : someStrings) {
			elements.add(new FormattedStringElement(tempString));
		}
	}

	public String toFormattedString() {
		if (elements.size() == 0) {
			return "null";
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.getFormattedText());
		}

		String tempString = tempBuffer.toString();
		if (tempString.length() == 0 || !tempString.contains("[")) {
			return tempString;
		} else {
			return FORMATTED_STRING_START_TOKEN + tempString;
		}
	}

	public String toUnformattedString() {
		if (elements.size() == 0) {
			return "null";
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.getUnformattedText());
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
