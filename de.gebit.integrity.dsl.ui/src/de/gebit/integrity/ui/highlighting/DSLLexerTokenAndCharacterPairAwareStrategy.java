/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.highlighting;

import java.text.BreakIterator;
import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.doubleClicking.LexerTokenAndCharacterPairAwareStrategy;
import org.eclipse.xtext.ui.editor.model.DocumentCharacterIterator;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import de.gebit.integrity.parser.antlr.internal.InternalDSLLexer;

/**
 * Custom implementation of {@link ITextDoubleClickStrategy}. This strategy is basically a copy of the parent classes'
 * findWord method and the parents' parent findWord. The latter was copied as-is, because access to it is not possible
 * from a subclass of a subclass. The former was changed in one specific place to exclude documentation comments from
 * the "double-click selects the entire token content" rule that is usually used for non-comment stuff.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DSLLexerTokenAndCharacterPairAwareStrategy extends LexerTokenAndCharacterPairAwareStrategy {

	@Override
	protected IRegion findWord(IDocument aDocument, int anOffset) {
		if (aDocument instanceof XtextDocument) {
			Iterator<ILexerTokenRegion> tempTokenIterator = ((XtextDocument) aDocument).getTokens().iterator();
			ILexerTokenRegion tempLeadingToken = null;
			ILexerTokenRegion tempTrailingToken = null;
			while (tempTokenIterator.hasNext()) {
				ILexerTokenRegion tempToken = tempTokenIterator.next();
				if (tempToken.getOffset() <= anOffset && tempToken.getOffset() + tempToken.getLength() >= anOffset) {
					if (tempLeadingToken != null) {
						tempTrailingToken = tempToken;
					} else {
						tempLeadingToken = tempToken;
					}
				}
				if (tempToken.getOffset() > anOffset) {
					break;
				}
			}
			if (tempLeadingToken != null) {
				try {
					if (tempLeadingToken.getLength() > 1
							&& (tempTrailingToken == null
									|| !Character.isLetter(aDocument.getChar(tempTrailingToken.getOffset())))
							&& tempLeadingToken.getLexerTokenType() != InternalDSLLexer.RULE_ML_DOC_COMMENT) {
						return new Region(tempLeadingToken.getOffset(), tempLeadingToken.getLength());
					} else if (tempTrailingToken != null) {
						return new Region(tempTrailingToken.getOffset(), tempTrailingToken.getLength());
					}
				} catch (BadLocationException ignore) {
				}
			}
		}
		return findWordAbstractWordAwareDoubleClickStrategy(aDocument, anOffset);
	}

	private IRegion findWordAbstractWordAwareDoubleClickStrategy(IDocument aDocument, int anOffset) {
		try {
			IRegion tempLine = aDocument.getLineInformationOfOffset(anOffset);

			if (anOffset == tempLine.getOffset() + tempLine.getLength()) {
				return null;
			}

			com.ibm.icu.text.BreakIterator tempBreakIter = createBreakIterator();
			tempBreakIter.setText(new DocumentCharacterIterator(aDocument));
			int tempStart = tempBreakIter.preceding(anOffset);
			if (tempStart == BreakIterator.DONE) {
				tempStart = tempLine.getOffset();
			}

			int tempEnd = tempBreakIter.following(anOffset);
			if (tempEnd == BreakIterator.DONE) {
				tempEnd = tempLine.getOffset() + tempLine.getLength();
			}

			if (tempBreakIter.isBoundary(anOffset)) {
				if (tempEnd - anOffset > anOffset - tempStart) {
					tempStart = anOffset;
				} else {
					tempEnd = anOffset;
				}
			}

			if (tempEnd == tempStart) {
				return null;
			}
			return new Region(tempStart, tempEnd - tempStart);
		} catch (BadLocationException e) {
			return null;
		}
	}

}
