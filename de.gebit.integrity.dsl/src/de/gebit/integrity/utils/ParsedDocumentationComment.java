/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import de.gebit.integrity.dsl.DocumentationComment;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;

/**
 *
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ParsedDocumentationComment {

	/**
	 * The source element that this was parsed from.
	 */
	protected DocumentationComment origin;

	/**
	 * Information about the source of the origin element.
	 */
	protected ModelSourceInformationElement sourceInfo;

	/**
	 * The core documentation text.
	 */
	protected String documentationText;

	/**
	 * A documentation comment starts with this.
	 */
	protected static final String COMMENT_START = "/**";

	/**
	 * A documentation comment ends with this.
	 */
	protected static final String COMMENT_END = "*/";

	/**
	 * Parses a given {@link DocumentationComment} and extracts the documentation info.
	 * 
	 * @param aComment
	 *            the comment element to be parsed
	 * @param aModelSourceInfo
	 *            the information about the source of the element, if available
	 * @throws ParseException
	 *             in case of parsing errors
	 */
	public ParsedDocumentationComment(DocumentationComment aComment, ModelSourceInformationElement aModelSourceInfo)
			throws ParseException {
		origin = aComment;
		sourceInfo = aModelSourceInfo;

		parse(aComment.getContent(), aModelSourceInfo);
	}

	/**
	 * Actually performs the heavy lifting.
	 * 
	 * @param aCommentString
	 *            the string to be parsed, right from the model element
	 * @param aModelSourceInfo
	 *            the information about the source of the element, if available
	 * @throws ParseException
	 *             in case of parsing errors
	 */
	protected void parse(String aCommentString, ModelSourceInformationElement aModelSourceInfo) throws ParseException {
		String tempCommentString = aCommentString.trim();

		if (!tempCommentString.startsWith(COMMENT_START)) {
			throw new ParseException("Doc comment does not start with '" + COMMENT_START + "'", aModelSourceInfo);
		}
		if (!tempCommentString.endsWith(COMMENT_END)) {
			throw new ParseException("Doc comment does not end with '" + COMMENT_END + "'", aModelSourceInfo);
		}

		StringBuilder tempDocumentationText = new StringBuilder();

		String[] tempLines = tempCommentString
				.substring(COMMENT_START.length(), aCommentString.length() - COMMENT_END.length()).split("[\\r\\n]+");
		for (String tempLine : tempLines) {
			String tempCleanLine = tempLine.trim();
			if (tempCleanLine.startsWith("*")) {
				tempCleanLine = tempCleanLine.substring(1);
				tempCleanLine = tempCleanLine.trim();
			}

			if (tempCleanLine.length() > 0) {
				if (tempDocumentationText.length() > 0) {
					tempDocumentationText.append(" ");
				}
				tempDocumentationText.append(tempCleanLine);
			}
		}

		documentationText = tempDocumentationText.toString();
	}

	public DocumentationComment getOrigin() {
		return origin;
	}

	public ModelSourceInformationElement getSourceInfo() {
		return sourceInfo;
	}

	public String getDocumentationText() {
		return documentationText;
	}

	/**
	 * These exceptions are thrown by the {@link ParsedDocumentationComment} constructors if parsing of a given
	 * {@link DocumentationComment} fails for whatever reason.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	public static final class ParseException extends Exception {

		/**
		 * Serial version.
		 */
		private static final long serialVersionUID = 8594735270542594094L;
		/**
		 * The model source information, if available.
		 */
		private ModelSourceInformationElement modelSourceInfo;

		/**
		 * Constructor.
		 */
		public ParseException(String aMessage) {
			super(aMessage);
		}

		/**
		 * Constructor.
		 */
		public ParseException(String aMessage, ModelSourceInformationElement aModelSourceInfo) {
			super((aModelSourceInfo != null ? aModelSourceInfo + " - " : "") + aMessage);
		}

		public ModelSourceInformationElement getModelSourceInfo() {
			return modelSourceInfo;
		}

	}

}
