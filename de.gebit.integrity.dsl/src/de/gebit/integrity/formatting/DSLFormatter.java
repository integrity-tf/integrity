/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package de.gebit.integrity.formatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

import de.gebit.integrity.services.DSLGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 * 
 * @author Rene Schneider - initial API and implementation
 */
public class DSLFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig aConfig) {
		DSLGrammarAccess tempGrammar = (DSLGrammarAccess) getGrammarAccess();

		// No line wrapping
		aConfig.setAutoLinewrap(9999);

		// No spaces after opening bracket or before closing bracket of custom operations...
		aConfig.setNoSpace().after(tempGrammar.getCustomOperationAccess().getLeftSquareBracketKeyword_0());
		aConfig.setNoSpace().before(tempGrammar.getCustomOperationAccess()
				.getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0());
		aConfig.setNoSpace().after(tempGrammar.getCustomOperationAccess()
				.getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0());
		aConfig.setNoSpace().before(tempGrammar.getCustomOperationAccess().getRightSquareBracketKeyword_6());

		// Put no space in front of the custom operation definition, but put a space behind a prefix operand, if
		// present. This results in the custom operation not having a space between the opening bracket and the
		// definition if there is no prefix, but having a space between a prefix and the definition if there is one.
		// Fixes issue #189.
		aConfig.setNoSpace().before(tempGrammar.getCustomOperationAccess().getDefinitionAssignment_3());
		aConfig.setSpace(" ").after(tempGrammar.getCustomOperationAccess()
				.getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0());

		// ...and the same with standard operations
		aConfig.setNoSpace().after(tempGrammar.getStandardOperationAccess().getLeftParenthesisKeyword_0());
		aConfig.setNoSpace().before(tempGrammar.getStandardOperationAccess()
				.getFirstOperandValueOrEnumValueOrOperationParserRuleCall_2_0());
		aConfig.setNoSpace().after(tempGrammar.getStandardOperationAccess()
				.getMoreOperandsValueOrEnumValueOrOperationParserRuleCall_4_2_0());
		aConfig.setNoSpace().before(tempGrammar.getStandardOperationAccess().getRightParenthesisKeyword_5());

		// No spaces at the end of lines and before whitespace between tokens
		aConfig.setNoSpace().before(tempGrammar.getNLRule());
		aConfig.setNoSpace().before(tempGrammar.getNLFORCEDRule());
		aConfig.setNoSpace().before(tempGrammar.getNEWLINERule());
		aConfig.setNoSpace().around(tempGrammar.getModelAccess().getNLParserRuleCall_1());

		// No spaces before colons, commas, after pluses or before/after hashes
		aConfig.setNoSpace().before(tempGrammar.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
		aConfig.setNoSpace().before(tempGrammar.getForkParameterAccess().getColonKeyword_2());
		aConfig.setNoSpace().before(tempGrammar.getParameterAccess().getColonKeyword_2());
		aConfig.setNoSpace().before(tempGrammar.getSuiteParameterAccess().getColonKeyword_2());
		aConfig.setNoSpace().before(tempGrammar.getVariantValueAccess().getColonKeyword_3());
		aConfig.setNoSpace().after(tempGrammar.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
		aConfig.setNoSpace().around(tempGrammar.getMethodReferenceAccess().getNumberSignKeyword_1());
		aConfig.setNoSpace().around(tempGrammar.getJavaConstantReferenceAccess().getNumberSignKeyword_1());
		aConfig.setNoSpace().before(tempGrammar.getKeyValuePairAccess().getColonKeyword_2());
		aConfig.setNoSpace().around(tempGrammar.getVariableAccess().getNumberSignKeyword_1_0());
		aConfig.setNoSpace().before(tempGrammar.getTimeSetAccess().getCommaKeyword_3_2_1());
		aConfig.setNoSpace().before(tempGrammar.getSuiteAccess().getCommaKeyword_9_2_1());

		// No spaces before/after encapsulating <>
		aConfig.setNoSpace().after(tempGrammar.getJavaConstantValueAccess().getLessThanSignKeyword_0());
		aConfig.setNoSpace().before(tempGrammar.getJavaConstantValueAccess().getGreaterThanSignKeyword_2());
		aConfig.setNoSpace().after(tempGrammar.getTypedNestedObjectAccess().getLessThanSignKeyword_0());
		aConfig.setNoSpace().before(tempGrammar.getTypedNestedObjectAccess().getGreaterThanSignKeyword_2());

		// No spaces at the end of table lines
		aConfig.setNoSpace().after(tempGrammar.getTableTestAccess().getVerticalLineKeyword_8_1());
		aConfig.setNoSpace().after(tempGrammar.getParameterTableHeaderAccess().getVerticalLineKeyword_2());
		aConfig.setNoSpace().after(tempGrammar.getResultTableHeaderAccess().getVerticalLineKeyword_3());
		aConfig.setNoSpace().after(tempGrammar.getParameterTableValueAccess().getVerticalLineKeyword_2());

		// No spaces before the 'T' divider in ISO date/time strings
		aConfig.setNoSpace()
				.after(tempGrammar.getIsoDateAndTimeValueAccess().getDateValueISODATETerminalRuleCall_0_0());

		// Indentations
		// Suites and Packages
		aConfig.setIndentation(tempGrammar.getPackageDefinitionAccess().getPackagedefKeyword_1(),
				tempGrammar.getPackageDefinitionAccess().getPackageendKeyword_7());
		aConfig.setIndentation(tempGrammar.getSuiteDefinitionAccess().getSuitedefKeyword_4(),
				tempGrammar.getSuiteDefinitionAccess().getSuiteendKeyword_15());

		// Objects
		aConfig.setIndentation(tempGrammar.getNestedObjectAccess().getLeftCurlyBracketKeyword_0(),
				tempGrammar.getNestedObjectAccess().getRightCurlyBracketKeyword_3());

		// Constant Variants
		aConfig.setIndentationIncrement()
				.before(tempGrammar.getConstantDefinitionAccess().getVariantValuesAssignment_6_1_0());
		aConfig.setIndentationDecrement()
				.after(tempGrammar.getConstantDefinitionAccess().getVariantValuesAssignment_6_1_0());

		// Tests and Calls
		aConfig.setIndentation(tempGrammar.getTestAccess().getNLParserRuleCall_2(),
				tempGrammar.getTestAccess().getNLParserRuleCall_7());
		aConfig.setIndentation(tempGrammar.getCallAccess().getNLParserRuleCall_1(),
				tempGrammar.getCallAccess().getNLParserRuleCall_7());
		aConfig.setIndentation(tempGrammar.getTableTestAccess().getNLParserRuleCall_1(),
				tempGrammar.getTableTestAccess().getNLFORCEDParserRuleCall_10());

		// Fork parameters
		aConfig.setIndentationIncrement().before(tempGrammar.getForkDefinitionAccess().getParametersAssignment_8_0());
		aConfig.setIndentationDecrement().after(tempGrammar.getForkDefinitionAccess().getParametersAssignment_8_0());
	}

	@Override
	public ITokenStream createFormatterStream(EObject aContext, String anIndent, ITokenStream anOut,
			boolean aPreserveWhitespaces) {
		return super.createFormatterStream(aContext, anIndent, new TableTestFormatterTokenStream(anOut),
				aPreserveWhitespaces);
	}

	@Override
	public ITokenStream createFormatterStream(String anIndent, ITokenStream anOut, boolean aPreserveWhitespaces) {
		return super.createFormatterStream(anIndent, new TableTestFormatterTokenStream(anOut), aPreserveWhitespaces);
	}

	/**
	 * This token stream is basically a filter that sits between the streams, catches tables and formats them before
	 * they're forwarded.
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public class TableTestFormatterTokenStream implements ITokenStream {

		/**
		 * Creates a new instance.
		 * 
		 * @param anOut
		 *            the target stream
		 */
		public TableTestFormatterTokenStream(ITokenStream anOut) {
			out = anOut;

			DSLGrammarAccess tempGrammar = (DSLGrammarAccess) getGrammarAccess();
			tableTestHeadStartRuleCall = tempGrammar.getTableTestAccess().getNLFORCEDParserRuleCall_4();
			tableTestRowStartRuleCall = tempGrammar.getTableTestAccess().getNLFORCEDParserRuleCall_9_0();
			tableTestEndRuleCall = tempGrammar.getTableTestAccess().getNLFORCEDParserRuleCall_10();
			whitespaceRuleCall = tempGrammar.getNLAccess().getWSTerminalRuleCall_1();

			tableColumnDelimiterKeywords.add(tempGrammar.getTableTestAccess().getVerticalLineKeyword_7());
			tableColumnDelimiterKeywords.add(tempGrammar.getTableTestAccess().getVerticalLineKeyword_8_1());
			tableColumnDelimiterKeywords.add(tempGrammar.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
			tableColumnDelimiterKeywords.add(tempGrammar.getParameterTableHeaderAccess().getVerticalLineKeyword_2());
			tableColumnDelimiterKeywords.add(tempGrammar.getParameterTableValueAccess().getVerticalLineKeyword_0());
			tableColumnDelimiterKeywords.add(tempGrammar.getParameterTableValueAccess().getVerticalLineKeyword_2());
			tableColumnDelimiterKeywords.add(tempGrammar.getResultTableHeaderAccess().getVerticalLineKeyword_0());
			tableColumnDelimiterKeywords.add(tempGrammar.getResultTableHeaderAccess().getVerticalLineKeyword_3());
		}

		/**
		 * The target stream.
		 */
		private ITokenStream out;

		/**
		 * The buffer to store the table currently processed.
		 */
		private List<List<List<TokenTuple>>> tableBuffer = new ArrayList<List<List<TokenTuple>>>();

		/**
		 * The current line in the current table.
		 */
		private List<List<TokenTuple>> currentTableLine;

		/**
		 * The current cell in the current table.
		 */
		private List<TokenTuple> currentTableCell;

		/**
		 * Whether we are inside a table at all.
		 */
		private boolean inTable;

		/**
		 * The rule encountered at the beginning of a table.
		 */
		private final RuleCall tableTestHeadStartRuleCall;

		/**
		 * The rule encountered at the beginning of a table row.
		 */
		private final RuleCall tableTestRowStartRuleCall;

		/**
		 * The rule encountered at the end of a table.
		 */
		private final RuleCall tableTestEndRuleCall;

		/**
		 * The whitespace rule.
		 */
		private final RuleCall whitespaceRuleCall;

		/**
		 * The possible keywords which delimit a table column.
		 */
		private final Set<Keyword> tableColumnDelimiterKeywords = new HashSet<Keyword>();

		@Override
		public void flush() throws IOException {
			out.flush();
		}

		@Override
		public void writeHidden(EObject aGrammarElement, String aValue) throws IOException {
			if (!inTable) {
				out.writeHidden(aGrammarElement, aValue);
				if (aGrammarElement == tableTestHeadStartRuleCall) {
					startNewTable();
				}
			} else {
				if (tableColumnDelimiterKeywords.contains(aGrammarElement)) {
					concludeTableCell();
					startNewTableCell();
				} else if (aGrammarElement == tableTestRowStartRuleCall) {
					concludeTableLine();
					startNewTableLine();
				}
				currentTableCell.add(new TokenTuple(aGrammarElement, aValue));
				if (aGrammarElement == tableTestEndRuleCall) {
					concludeTable();
				}
			}
		}

		private void startNewTable() {
			inTable = true;
			tableBuffer.clear();
			startNewTableLine();
		}

		private void concludeTable() throws IOException {
			concludeTableLine();
			inTable = false;
			formatTable();
			writeTableToOut();
		}

		private void concludeTableLine() {
			concludeTableCell();
			tableBuffer.add(currentTableLine);
			currentTableLine = null;
		}

		private void concludeTableCell() {
			currentTableLine.add(currentTableCell);
			currentTableCell = null;
		}

		private void startNewTableLine() {
			currentTableLine = new ArrayList<List<TokenTuple>>();
			startNewTableCell();
		}

		private void startNewTableCell() {
			currentTableCell = new ArrayList<TokenTuple>();
		}

		private void writeTableToOut() throws IOException {
			for (List<List<TokenTuple>> tempLine : tableBuffer) {
				for (List<TokenTuple> tempCell : tempLine) {
					for (TokenTuple tempTuple : tempCell) {
						tempTuple.writeHidden(out);
					}
				}
			}
		}

		private void formatTable() {
			List<Integer> tempColWidth = new ArrayList<Integer>();

			for (int i = 0; i < 2; i++) {
				boolean tempInSurveyMode = (i == 0);
				for (List<List<TokenTuple>> tempLine : tableBuffer) {
					int tempColumn = 0;
					for (int k = 1; k < tempLine.size() - 1; k++) { // first isn't a cell, but the whitespace on the
																	// left, and last is the whitespace on the right
						List<TokenTuple> tempCell = tempLine.get(k);

						int tempLength = 0;

						for (TokenTuple tempToken : tempCell) {
							tempLength += tempToken.getValueLength();
						}

						if (tempInSurveyMode) {
							// just see whether we have found a new max size
							if (tempColWidth.size() > tempColumn) {
								if (tempColWidth.get(tempColumn) < tempLength) {
									tempColWidth.set(tempColumn, tempLength);
								}
							} else {
								tempColWidth.add(tempLength);
							}
						} else {
							// inflate the column width to the max size
							int tempCharsToAdd = tempColWidth.get(tempColumn) - tempLength;
							if (tempCharsToAdd > 0) {
								tempCell.add(new TokenTuple(whitespaceRuleCall, generateWhitespace(tempCharsToAdd)));
							}
						}

						tempColumn++;
					}
				}
			}
		}

		private String generateWhitespace(int aNumberOfCharacters) {
			StringBuffer tempBuffer = new StringBuffer();
			for (int i = 0; i < aNumberOfCharacters; i++) {
				tempBuffer.append(' ');
			}

			return tempBuffer.toString();
		}

		@Override
		public void writeSemantic(EObject aGrammarElement, String aValue) throws IOException {
			out.writeSemantic(aGrammarElement, aValue);
		}

	}

	private static class TokenTuple {

		/**
		 * The grammar element.
		 */
		private EObject grammarElement;

		/**
		 * The string value.
		 */
		private String value;

		TokenTuple(EObject aGrammarElement, String aValue) {
			grammarElement = aGrammarElement;
			value = aValue;
		}

		public void writeHidden(ITokenStream anOut) throws IOException {
			anOut.writeHidden(grammarElement, value);
		}

		public int getValueLength() {
			if (value != null) {
				return value.length();
			} else {
				return 0;
			}
		}
	}
}
