/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.utils.ParsedDocumentationComment.DocCommentElement;
import de.gebit.integrity.utils.ParsedDocumentationComment.DocCommentElementType;
import htmlflow.HtmlView;
import htmlflow.HtmlWriter;
import htmlflow.HtmlWriterComposite;
import htmlflow.TextNode;
import htmlflow.elements.HtmlBr;
import htmlflow.elements.HtmlLi;
import htmlflow.elements.HtmlOl;
import htmlflow.elements.HtmlP;
import htmlflow.elements.HtmlSpan;
import htmlflow.elements.HtmlUl;

/**
 * Base {@link HtmlView} class for Integrity-related {@link HtmlView}s. Allows to get a text-content-only version of
 * every document created.
 *
 * @param <T>
 *            the type
 * @author Rene Schneider - initial API and implementation
 *
 */
public class IntegrityHtmlView<T> extends HtmlView<T> {

	/**
	 * Returns the documents' text contents only.
	 * 
	 * @return
	 */
	public String textOnly() {
		return recursivelyWalkComposite(getTextOnlyEntryNode());
	}

	/**
	 * Returns the node at which to start for getting the text-only version.
	 * 
	 * @return
	 */
	protected HtmlWriterComposite<?, ?> getTextOnlyEntryNode() {
		return this;
	}

	/**
	 * Recursively walks a given {@link HtmlWriterComposite} to get the textual output.
	 * 
	 * @param aComposite
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected String recursivelyWalkComposite(HtmlWriterComposite<?, ?> aComposite) {
		StringJoiner tempBuffer = new StringJoiner(" ");
		for (HtmlWriter<?> tempChild : aComposite.getChildren()) {
			if (tempChild instanceof HtmlWriterComposite) {
				if (((HtmlWriterComposite) tempChild).getClassAttribute().contains(CSSClasses.HIDDEN)) {
					// Skip hidden elements, because they won't be visible in the default view of the page and thus
					// we cannot practically show those in the results
					continue;
				}
				tempBuffer.add(recursivelyWalkComposite((HtmlWriterComposite<?, ?>) tempChild));
			} else if (tempChild instanceof TextNode) {
				tempBuffer.add(((TextNode<?>) tempChild).getText());
			}
		}

		return tempBuffer.toString();
	}

	/**
	 * Parses a list of {@link DocCommentElement}s and creates corresponding HTML elements inside a provided container.
	 * 
	 * @param aContainer
	 * @param someElements
	 */
	protected void attachFormattedDocumentationText(HtmlWriterComposite<?, ?> aContainer,
			List<DocCommentElement> someElements) {
		Stack<HtmlWriterComposite<?, ?>> tempHtmlStack = new Stack<>();
		Stack<DocCommentElement> tempElementStack = new Stack<>();
		tempHtmlStack.add(aContainer);

		try {
			for (DocCommentElement tempElement : someElements) {
				if (tempElement.getType() == DocCommentElementType.TEXT) {
					tempHtmlStack.peek().addChild(new TextNode<>(tempElement.getText()));
				} else {
					if (tempElement.isTerminal()) {
						if (tempElement.getType().isSpanning()) {
							switch (tempElement.getType()) {
							case ORDERED_LIST:
							case UNORDERED_LIST:
								attachFormattedDocumentationTextCloseLastListElement(tempHtmlStack, tempElementStack);
								tempElementStack.pop();
								tempHtmlStack.pop();
								break;
							default:
								tempElementStack.pop();
								tempHtmlStack.pop();
								break;
							}
						}
					} else {
						switch (tempElement.getType()) {
						case TEXT:
							throw new ThisShouldNeverHappenException("Text elements should have already been handled");
						case NEWLINE:
							tempHtmlStack.peek().addChild(new HtmlBr<>());
							break;
						case PARAGRAPH:
							attachFormattedDocumentationTextCloseLastParagraph(tempHtmlStack, tempElementStack);
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlP<>(), null);
							break;
						case BOLD:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlSpan<>(), CSSClasses.BOLD);
							break;
						case CODE:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlSpan<>(), CSSClasses.CODE);
							break;
						case ITALIC:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlSpan<>(), CSSClasses.ITALIC);
							break;
						case HEADER_1:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlP<>(), CSSClasses.HEADER_1);
							break;
						case HEADER_2:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlP<>(), CSSClasses.HEADER_2);
							break;
						case ORDERED_LIST:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlOl<>(), null);
							break;
						case UNORDERED_LIST:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlUl<>(), null);
							break;
						case LIST_ELEMENT:
							attachFormattedDocumentationTextPushHtmlElement(tempHtmlStack, tempElementStack,
									tempElement, new HtmlLi<>(), null);
							break;
						default:
							// Ignore unknown elements
							break;
						}
					}
				}
			}
		} catch (EmptyStackException exc) {
			aContainer.addChild(new TextNode<>("Caught EmptyStackException during text parsing: " + exc.getMessage()));
		}
	}

	/**
	 * Helper method for {@link #attachFormattedDocumentationText(HtmlWriterComposite, List)}.
	 * 
	 * @param aHtmlStack
	 * @param anElementStack
	 */
	protected void attachFormattedDocumentationTextCloseLastParagraph(Stack<HtmlWriterComposite<?, ?>> aHtmlStack,
			Stack<DocCommentElement> anElementStack) {
		if (!aHtmlStack.isEmpty() && !anElementStack.isEmpty()) {
			if (anElementStack.peek().getType() == DocCommentElementType.PARAGRAPH) {
				anElementStack.pop();
				aHtmlStack.pop();
			}
		}
	}

	/**
	 * Helper method for {@link #attachFormattedDocumentationText(HtmlWriterComposite, List)}.
	 * 
	 * @param aHtmlStack
	 * @param anElementStack
	 */
	protected void attachFormattedDocumentationTextCloseLastListElement(Stack<HtmlWriterComposite<?, ?>> aHtmlStack,
			Stack<DocCommentElement> anElementStack) {
		if (!aHtmlStack.isEmpty() && !anElementStack.isEmpty()) {
			if (anElementStack.peek().getType() == DocCommentElementType.LIST_ELEMENT) {
				anElementStack.pop();
				aHtmlStack.pop();
			}
		}
	}

	/**
	 * Helper method for {@link #attachFormattedDocumentationText(HtmlWriterComposite, List)}.
	 * 
	 * @param aHtmlStack
	 * @param anElementStack
	 * @param anElement
	 * @param aNewElement
	 */
	protected void attachFormattedDocumentationTextPushHtmlElement(Stack<HtmlWriterComposite<?, ?>> aHtmlStack,
			Stack<DocCommentElement> anElementStack, DocCommentElement anElement, HtmlWriterComposite<?, ?> aNewElement,
			String aFormatClass) {
		if (aFormatClass != null) {
			aNewElement.classAttr(aFormatClass);
		}
		aHtmlStack.peek().addChild(aNewElement);
		aHtmlStack.push(aNewElement);
		anElementStack.push(anElement);
	}

}
