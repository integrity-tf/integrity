/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.string;

/**
 * These {@link FormattedString} elements are intended to represent single formatting tokens which don't "wrap" a piece
 * of text. Examples are line breaks or tabs.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FormatTokenElement extends AbstractFormattedStringElement {

	/**
	 * The token type.
	 */
	private FormatTokenType type;

	/**
	 * The text to use as a replacement for the token if the {@link FormattedString} is serialized into a {@link String}
	 * without any formatting tokens.
	 */
	private String replacement;

	/**
	 * Creates a new instance.
	 * 
	 * @param aType
	 *            the token type
	 */
	public FormatTokenElement(FormatTokenType aType) {
		type = aType;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aType
	 *            the token type
	 * @param aReplacement
	 *            the replacement text
	 */
	public FormatTokenElement(FormatTokenType aType, String aReplacement) {
		type = aType;
		replacement = aReplacement;
	}

	public FormatTokenType getType() {
		return type;
	}

	@Override
	public String toUnformattedString() {
		return replacement != null ? replacement : "";
	}

	@Override
	public String toFormattedString() {
		if (type == null) {
			return "";
		}

		return type.getTag(replacement);
	}

	/**
	 * The format token types represent the actual tokens which can be used to format a string.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static enum FormatTokenType {

		/**
		 * Represents a line break.
		 */
		NEWLINE("NL"),

		/**
		 * Represents a tabulator for indenting following text.
		 */
		TAB("T");

		/**
		 * The tag name.
		 */
		private String tag;

		private FormatTokenType(String aTag) {
			tag = aTag;
		}

		private String getTag(String aReplacement) {
			return "[" + tag + (aReplacement != null ? "|" + aReplacement : "") + "]";
		}

	}

}
