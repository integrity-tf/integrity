/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.modelsource;

/**
 * Container for source-related information about a model element.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ModelSourceInformationElement {

	/**
	 * The original textual snippet from which the element has been parsed.
	 */
	private String snippet;

	/**
	 * The (starting) line number in the source file.
	 */
	private int lineNumber;

	/**
	 * The path to the source file.
	 */
	private String filePath;

	/**
	 * Creates an instance.
	 * 
	 * @param aSnippet
	 *            the original snippet
	 * @param aFilePath
	 *            the file path
	 * @param aLineNumber
	 *            the line number
	 */
	public ModelSourceInformationElement(String aSnippet, String aFilePath, int aLineNumber) {
		snippet = aSnippet;
		filePath = aFilePath;
		lineNumber = aLineNumber;
	}

	public String getSnippet() {
		return snippet;
	}

	public String getFilePath() {
		return filePath;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public String toString() {
		return getFilePath() + ":" + getLineNumber();
	}

}
