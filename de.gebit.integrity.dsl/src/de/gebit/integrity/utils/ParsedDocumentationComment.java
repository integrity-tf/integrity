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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
	 * The entire raw textual content (including @ elements, but excluding comment *s).
	 */
	protected String rawText;

	/**
	 * The core documentation text (non-parsed).
	 */
	protected String documentationText;

	/**
	 * The parsed core documentation text. May be empty if {@link #documentationText} is empty.
	 */
	protected List<DocCommentElement> documentationTextElements;

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
		// Unnamed results are allowed by default
		this(aComment, aModelSourceInfo, true);
	}

	/**
	 * Parses a given {@link DocumentationComment} and extracts the documentation info.
	 * 
	 * @param aComment
	 *            the comment element to be parsed
	 * @param aModelSourceInfo
	 *            the information about the source of the element, if available
	 * @param anAllowUnnamedResultsFlag
	 *            whether to apply a heuristic in determining if we have an unnamed result (false = all results named)
	 * @throws ParseException
	 *             in case of parsing errors
	 */
	public ParsedDocumentationComment(DocumentationComment aComment, ModelSourceInformationElement aModelSourceInfo,
			boolean anAllowUnnamedResultsFlag) throws ParseException {
		origin = aComment;
		sourceInfo = aModelSourceInfo;

		parse(aComment.getContent(), aModelSourceInfo, anAllowUnnamedResultsFlag);
	}

	/**
	 * Actually performs the heavy lifting.
	 * 
	 * @param aCommentString
	 *            the string to be parsed, right from the model element
	 * @param aModelSourceInfo
	 *            the information about the source of the element, if available
	 * @param anAllowUnnamedResultsFlag
	 *            whether to apply a heuristic in determining if we have an unnamed result (false = all results named)
	 * @throws ParseException
	 *             in case of parsing errors
	 */
	@SuppressWarnings("unchecked")
	protected void parse(String aCommentString, ModelSourceInformationElement aModelSourceInfo,
			boolean anAllowUnnamedResultsFlag) throws ParseException {
		String tempCommentString = aCommentString.trim();

		if (!tempCommentString.startsWith(COMMENT_START)) {
			throw new ParseException("Doc comment does not start with '" + COMMENT_START + "'", aModelSourceInfo);
		}
		if (!tempCommentString.endsWith(COMMENT_END)) {
			throw new ParseException("Doc comment does not end with '" + COMMENT_END + "'", aModelSourceInfo);
		}

		StringBuilder tempRawText = new StringBuilder();
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

			tempRawText.append(tempCleanLine + "\n");

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

		rawText = tempRawText.toString();
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

		List<String> tempResultDocs = new ArrayList<String>();
		tempResultDocs.addAll(tempTags.getOrDefault(DOCUMENTATION_TAG_RESULT, (List<String>) Collections.EMPTY_LIST));
		tempResultDocs.addAll(tempTags.getOrDefault(DOCUMENTATION_TAG_RETURN, (List<String>) Collections.EMPTY_LIST));
		for (String tempResultLine : tempResultDocs) {
			String tempNamedResultName = null;
			String tempResultDocumentation = tempResultLine;
			String[] tempParts = tempResultLine.split("\\s+", 2);

			if ((anAllowUnnamedResultsFlag && tempResultDocs.size() == 1) || tempParts.length == 1) {
				// If we allow an unnamed result and there is only one result documented, assume it is the unnamed
				// result. Also assume that if the line cannot be splitted because there are no spaces. We do not need
				// to do anything here in cases of unnamed results.
			} else {
				// This is assumed to be a named result. Those have the result name in the beginning.
				if (tempParts.length == 2) {
					tempNamedResultName = tempParts[0].substring(0,
							tempParts[0].length() - (tempParts[0].endsWith(":") ? 1 : 0));
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

	public String getRawText() {
		return rawText;
	}

	public String getDocumentationText() {
		return documentationText;
	}

	/**
	 * Lazily calculates the documentation text elements and returns them.
	 * 
	 * @return
	 */
	public List<DocCommentElement> getDocumentationTextElements() {
		if (documentationText != null && documentationTextElements == null) {
			documentationTextElements = tokenizeCommentText(documentationText);
		}
		return documentationTextElements;
	}

	/**
	 * Generates a representation of this entire documentation comments' content in Javadoc-style HTML. This includes
	 * all known @ elements.
	 * 
	 * @return
	 */
	public String getJavadocStyleFullDocumentation() {
		StringBuilder tempBuilder = new StringBuilder();

		if (documentationText != null) {
			tempBuilder.append(documentationText);
		}

		if (parameterDocumentationTexts.size() > 0) {
			tempBuilder.append("<p><b>Parameters</b><br><ul style=\"list-style-type: none;\">");
			for (Entry<String, String> tempEntry : getSortedParameterDocumentationTexts()) {
				tempBuilder.append("<li><b>" + tempEntry.getKey() + "</b>: " + tempEntry.getValue() + "</li>");
			}
			tempBuilder.append("</ul></p>");
		}

		if (resultDocumentationTexts.size() > 0) {
			tempBuilder.append("<p><b>Results</b><br><ul style=\"list-style-type: none;\">");
			for (Entry<String, String> tempEntry : getSortedResultDocumentationTexts()) {
				tempBuilder.append("<li>" + (tempEntry.getKey() != null ? "<b>" + tempEntry.getKey() + "</b>: " : "")
						+ tempEntry.getValue() + "</li>");
			}
			tempBuilder.append("</ul></p>");
		}

		return tempBuilder.toString();
	}

	public Map<String, String> getParameterDocumentationTexts() {
		return parameterDocumentationTexts;
	}

	public List<Entry<String, String>> getSortedParameterDocumentationTexts() {
		return parameterDocumentationTexts.entrySet().stream().sorted(new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> aFirst, Entry<String, String> aSecond) {
				return aFirst.getKey().compareTo(aSecond.getKey());
			}

		}).collect(Collectors.toList());
	}

	public Map<String, String> getResultDocumentationTexts() {
		return resultDocumentationTexts;
	}

	public List<Entry<String, String>> getSortedResultDocumentationTexts() {
		return resultDocumentationTexts.entrySet().stream().sorted(new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> aFirst, Entry<String, String> aSecond) {
				return aFirst.getKey().compareTo(aSecond.getKey());
			}

		}).collect(Collectors.toList());
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

	/**
	 * The pattern used to split documentation comments into elements.
	 */
	protected static final Pattern DOC_COMMENT_TOKENIZER_PATTERN = Pattern.compile("(.*?)<(/?)(\\w+)/?>([^<]*)");

	/**
	 * Splits the documentation comment text into elements.
	 * 
	 * @param aText
	 * @return
	 */
	protected List<DocCommentElement> tokenizeCommentText(String aText) {
		List<DocCommentElement> tempResults = new ArrayList<DocCommentElement>();

		Matcher tempMatcher = DOC_COMMENT_TOKENIZER_PATTERN.matcher(aText);
		while (tempMatcher.find()) {
			if (tempMatcher.group(1) != null && tempMatcher.group(1).length() > 0) {
				tempResults.add(new DocCommentElement(tempMatcher.group(1), DocCommentElementType.TEXT, false));
			}

			for (DocCommentElementType tempTypeCandidate : DocCommentElementType.values()) {
				if (tempTypeCandidate.doesMatch(tempMatcher.group(3))) {
					tempResults.add(new DocCommentElement(tempMatcher.group(3), tempTypeCandidate,
							(tempMatcher.group(2) != null && tempMatcher.group(2).length() > 0)));
				}
			}

			if (tempMatcher.group(4) != null && tempMatcher.group(4).length() > 0) {
				tempResults.add(new DocCommentElement(tempMatcher.group(4), DocCommentElementType.TEXT, false));
			}
		}

		if (tempResults.size() == 0 && aText != null && aText.length() > 0) {
			// The text is just text with no single element
			tempResults.add(new DocCommentElement(aText, DocCommentElementType.TEXT, false));
		}

		return tempResults;
	}

	/**
	 * The supported types of elements in documentation comments.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	public enum DocCommentElementType {

		/**
		 * Simple, plain text.
		 */
		TEXT(false),

		/**
		 * New line.
		 */
		NEWLINE(false, "br"),

		/**
		 * New paragraph.
		 */
		PARAGRAPH(true, "p"),

		/**
		 * Unordered list.
		 */
		UNORDERED_LIST(true, "ul"),

		/**
		 * Ordered list.
		 */
		ORDERED_LIST(true, "ol"),

		/**
		 * List element.
		 */
		LIST_ELEMENT(true, "li"),

		/**
		 * Bold text.
		 */
		BOLD(true, "b", "strong"),

		/**
		 * Italic text.
		 */
		ITALIC(true, "i"),

		/**
		 * Code segments.
		 */
		CODE(true, "code"),

		/**
		 * Biggest header.
		 */
		HEADER_1(true, "h1"),

		/**
		 * Second-biggest header.
		 */
		HEADER_2(true, "h2");

		/**
		 * All possible matching sequences.
		 */
		private String[] matches;

		/**
		 * Whether this element "spans" a certain amount of text.
		 */
		private boolean spanning;

		/**
		 * Constructor.
		 * 
		 * @param someMatches
		 */
		DocCommentElementType(boolean aSpanningFlag, String... someMatches) {
			spanning = aSpanningFlag;
			matches = someMatches;
		}

		public boolean isSpanning() {
			return spanning;
		}

		/**
		 * Whether a provided possible match matches this type.
		 * 
		 * @param aPossibleMatch
		 * @return
		 */
		public boolean doesMatch(String aPossibleMatch) {
			for (String tempMatch : matches) {
				if (aPossibleMatch.toLowerCase().equals(tempMatch)) {
					return true;
				}
			}

			return false;
		}

	}

	/**
	 * A single element of a documentation comment. Can be a textual element or a structural formatting information.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	public static final class DocCommentElement {

		/**
		 * Text of this element.
		 */
		private String text;

		/**
		 * Type of the element.
		 */
		private DocCommentElementType type;

		/**
		 * Whether this is a termination element.
		 */
		private boolean terminal;

		/**
		 * Constructor.
		 * 
		 * @param aText
		 * @param aType
		 * @param aTerminalFlag
		 */
		public DocCommentElement(String aText, DocCommentElementType aType, boolean aTerminalFlag) {
			text = aText;
			type = aType;
			terminal = aTerminalFlag;
		}

		public String getText() {
			return text;
		}

		public DocCommentElementType getType() {
			return type;
		}

		public boolean isTerminal() {
			return terminal;
		}

	}

}
