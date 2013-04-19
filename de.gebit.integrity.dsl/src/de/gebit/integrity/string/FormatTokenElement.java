/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.string;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FormatTokenElement extends AbstractFormattedStringElement {

	private FormatTokenType type;

	private String replacement;

	public FormatTokenElement(FormatTokenType aType) {
		type = aType;
	}

	public FormatTokenElement(FormatTokenType aType, String aReplacement) {
		type = aType;
		replacement = aReplacement;
	}

	public FormatTokenType getType() {
		return type;
	}

	@Override
	public String getUnformattedText() {
		return replacement != null ? replacement : "";
	}

	@Override
	public String getFormattedText() {
		if (type == null) {
			return "";
		}

		return type.getTag(replacement);
	}

	/**
	 * 
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static enum FormatTokenType {

		NEWLINE("NL"),

		TAB("T");

		private String tag;

		private FormatTokenType(String aTag) {
			tag = aTag;
		}

		public String getTag(String aReplacement) {
			return "[" + tag + (aReplacement != null ? "|" + aReplacement : "") + "]";
		}

	}

}
