/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

import java.util.StringJoiner;

import htmlflow.HtmlView;
import htmlflow.HtmlWriter;
import htmlflow.HtmlWriterComposite;
import htmlflow.TextNode;

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

}
