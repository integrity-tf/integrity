/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.dsl.DocumentationComment;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;

/**
 * The parsed version of a JavaDoc-style Integrity documentation comment.
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
	 * Non-critical parse exceptions that were encountered while parsing the comment. These exceptions did not result in
	 * an abortion of the parsing process, but point to problems nevertheless.
	 */
	protected List<ParseException> parseExceptions = new ArrayList<>();

	/**
	 * The core documentation text.
	 */
	protected String documentationText;

	/**
	 * Documentation for parameters (@param).
	 */
	protected Map<String, String> parameterDocumentationTexts = new HashMap<String, String>();

	/**
	 * Documentation for results (@result). The one for the default result is added with key null.
	 */
	protected Map<String, String> resultDocumentationTexts = new HashMap<String, String>();

	/**
	 * A documentation comment starts with this.
	 */
	protected static final String COMMENT_START = "/**";

	/**
	 * A documentation comment ends with this.
	 */
	protected static final String COMMENT_END = "*/";

	/**
	 * The prefix that starts a documentation tag.
	 */
	protected static final String DOCUMENTATION_TAG_START = "@";

	/**
	 * The documentation tag for parameter descriptions.
	 */
	protected static final String DOCUMENTATION_TAG_PARAMETER = "param";

	/**
	 * The documentation tag for result descriptions.
	 */
	protected static final String DOCUMENTATION_TAG_RESULT = "result";

	/**
	 * The documentation tag for result descriptions. Can be used alternatively to {@link #DOCUMENTATION_TAG_RESULT}.
	 */
	protected static final String DOCUMENTATION_TAG_RETURN = "return";

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
	@SuppressWarnings("unchecked")
	protected void parse(String aCommentString, ModelSourceInformationElement aModelSourceInfo) throws ParseException {
		String tempCommentString = aCommentString.trim();

		if (!tempCommentString.startsWith(COMMENT_START)) {
			throw new ParseException("Doc comment does not start with '" + COMMENT_START + "'", aModelSourceInfo);
		}
		if (!tempCommentString.endsWith(COMMENT_END)) {
			throw new ParseException("Doc comment does not end with '" + COMMENT_END + "'", aModelSourceInfo);
		}

		StringBuilder tempDocumentationText = new StringBuilder();
		Map<String, List<String>> tempTags = new HashMap<>();

		StringBuilder tempCurrentTagValue = new StringBuilder();
		String tempCurrentTagName = null;
		int tempLineCount = 0;

		String[] tempLines = tempCommentString
				.substring(COMMENT_START.length(), aCommentString.length() - COMMENT_END.length()).split("[\\r\\n]+");
		for (String tempLine : tempLines) {
			String tempCleanLine = tempLine.trim();
			if (tempCleanLine.startsWith("*")) {
				tempCleanLine = tempCleanLine.substring(1);
				tempCleanLine = tempCleanLine.trim();
			}

			if (tempCleanLine.startsWith(DOCUMENTATION_TAG_START)) {
				if (tempCurrentTagName != null) {
					tempTags.computeIfAbsent(tempCurrentTagName, emptyList -> new ArrayList<String>())
							.add(tempCurrentTagValue.toString().trim());
					tempCurrentTagName = null;
				}

				tempCleanLine = tempCleanLine.substring(DOCUMENTATION_TAG_START.length());
				tempCurrentTagName = tempCleanLine.split("\\s+")[0];
				if (tempCurrentTagName.length() == 0) {
					parseExceptions.add(new ParseException("Encountered empty tag name",
							addLines(aModelSourceInfo, tempLineCount)));
					tempCurrentTagName = null;
				} else {
					tempCurrentTagValue = new StringBuilder(tempCleanLine.substring(tempCurrentTagName.length()));
				}
			} else {
				if (tempCurrentTagName != null) {
					if (tempCurrentTagValue.length() > 0) {
						tempCurrentTagValue.append(" ");
					}
					tempCurrentTagValue.append(tempCleanLine);
				} else {
					if (tempCleanLine.length() > 0) {
						if (tempDocumentationText.length() > 0) {
							tempDocumentationText.append(" ");
						}
						tempDocumentationText.append(tempCleanLine);
					}
				}
			}

			tempLineCount++;
		}

		// At the end there may still be data for a tag in the buffers
		if (tempCurrentTagName != null) {
			tempTags.computeIfAbsent(tempCurrentTagName, emptyList -> new ArrayList<String>())
					.add(tempCurrentTagValue.toString().trim());
			tempCurrentTagName = null;
		}

		documentationText = tempDocumentationText.toString();

		List<String> tempParameterDocs = tempTags.getOrDefault(DOCUMENTATION_TAG_PARAMETER,
				(List<String>) Collections.EMPTY_LIST);
		for (String tempParameterLine : tempParameterDocs) {
			String[] tempParts = tempParameterLine.split("\\s+", 2);
			if (tempParts.length == 2) {
				if (tempParts[0].endsWith(":")) {
					tempParts[0] = tempParts[0].substring(0, tempParts[0].length() - 1);
				}
				parameterDocumentationTexts.put(tempParts[0], tempParts[1]);
			}
		}

		List<String> tempResultDocs = tempTags.getOrDefault(DOCUMENTATION_TAG_RESULT,
				(List<String>) Collections.EMPTY_LIST);
		tempResultDocs.addAll(tempTags.getOrDefault(DOCUMENTATION_TAG_RETURN, (List<String>) Collections.EMPTY_LIST));
		for (String tempResultLine : tempResultDocs) {
			String tempNamedResultName = null;
			String tempResultDocumentation = tempResultLine;

			// This could be a named result. Those have the result name in the beginning, followed by mandatory ':'
			String[] tempParts = tempResultLine.split("\\s+", 2);
			if (tempParts.length == 2) {
				if (tempParts[0].endsWith(":")) {
					tempNamedResultName = tempParts[0].substring(0, tempParts[0].length() - 1);
					tempResultDocumentation = tempParts[1];
				}
			}

			resultDocumentationTexts.put(tempNamedResultName, tempResultDocumentation);
		}
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

	public Map<String, String> getParameterDocumentationTexts() {
		return parameterDocumentationTexts;
	}

	public Map<String, String> getResultDocumentationTexts() {
		return resultDocumentationTexts;
	}

	/**
	 * Clones the given {@link ModelSourceInformationElement} and adds a given number of lines to the line number of the
	 * provided element.
	 * 
	 * @param anElement
	 *            the base element
	 * @param aNumberOfLines
	 *            the number of lines to add
	 * @return a clone with a changed line number
	 */
	protected static final ModelSourceInformationElement addLines(ModelSourceInformationElement anElement,
			int aNumberOfLines) {
		return new ModelSourceInformationElement(anElement.getSnippet(), anElement.getFilePath(),
				anElement.getLineNumber() + aNumberOfLines);
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
			modelSourceInfo = aModelSourceInfo;
		}

		public ModelSourceInformationElement getModelSourceInfo() {
			return modelSourceInfo;
		}

	}

}
