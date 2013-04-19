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

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FormattedStringElement extends AbstractFormattedStringElement {

	private String text;

	private List<FormatFlag> formatFlags = new ArrayList<FormatFlag>();

	public FormattedStringElement(String aText) {
		text = aText;
	}

	public FormattedStringElement(String aText, FormatFlag... someFlags) {
		text = aText;
		formatFlags.addAll(Arrays.asList(someFlags));
	}

	@Override
	public String getUnformattedText() {
		return text;
	}

	public List<FormatFlag> getFormatFlags() {
		return formatFlags;
	}

	@Override
	public String getFormattedText() {
		StringBuilder tempBuilder = new StringBuilder();
		for (FormatFlag tempFlag : formatFlags) {
			tempBuilder.append(tempFlag.getStartTag());
		}
		// Opening brackets in the text need to be escaped
		tempBuilder.append(text == null ? "null" : text.replace("[", "[["));
		for (int i = formatFlags.size() - 1; i >= 0; i--) {
			tempBuilder.append(formatFlags.get(i).getEndTag());
		}

		return tempBuilder.toString();
	}

	/**
	 * 
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static enum FormatFlag {

		BOLD("B"),

		UNDERLINE("UL"),

		ITALIC("I");

		private String tag;

		private FormatFlag(String aTag) {
			tag = aTag;
		}

		public String getStartTag() {
			return "[" + tag + "]";
		}

		public String getEndTag() {
			return "[/" + tag + "]";
		}

	}

}
