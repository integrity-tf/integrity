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

	public FormatTokenElement(FormatTokenType aType) {
		type = aType;
	}

	public FormatTokenType getType() {
		return type;
	}

	@Override
	public String getUnformattedText() {
		return "";
	}

	@Override
	public String getFormattedText() {
		if (type == null) {
			return "";
		}

		return type.getTag();
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

		public String getTag() {
			return "[" + tag + "]";
		}

	}

}
