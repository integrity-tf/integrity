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

	protected List<AbstractFormattedStringElement> elements = new ArrayList<AbstractFormattedStringElement>();

	public FormattedString(String aText) {
		if (aText != null) {
			elements.add(new FormattedStringElement(aText));
		}
	}

	public FormattedString(String aText, FormatFlag... someFlags) {
		if (aText != null) {
			elements.add(new FormattedStringElement(aText, someFlags));
		}
	}

	public FormattedString(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	public void addElement(AbstractFormattedStringElement anElement) {
		elements.add(anElement);
	}

	public void addElements(AbstractFormattedStringElement... someElements) {
		elements.addAll(Arrays.asList(someElements));
	}

	public String getFormattedString() {
		if (elements.size() == 0) {
			return null;
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.getFormattedText());
		}
		return tempBuffer.toString();
	}

	public String getUnformattedString() {
		if (elements.size() == 0) {
			return null;
		}

		StringBuffer tempBuffer = new StringBuffer();
		for (AbstractFormattedStringElement tempElement : elements) {
			tempBuffer.append(tempElement.getUnformattedText());
		}
		return tempBuffer.toString();
	}

	@Override
	public String toString() {
		return getUnformattedString();
	}

}
