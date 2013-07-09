/*******************************************************************************
 * Copyright (c) 2013 GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package de.gebit.integrity.ui.outline;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Constains all outline relevant formatting configuration, styles etc.
 *
 * @author tilois
 */
public class OutlineFormatting {
	/** Gray color. */
	public final static RGB GRAY = new RGB(201, 201, 201);

	/**
	 * Style for parameters.
	 * @return Style for parameters.
	 */
	public TextStyle suiteParameterTextStyle() {
		return defaultTextStyle();
	}

	/**
	 * Style for suites.
	 * @return Style for suites.
	 */
	public TextStyle suiteTextStyle() {
		return defaultTextStyle();
	}

	/**
	 * Style for variables.
	 * @return Style for variables.
	 */
	public TextStyle variableDefinitionTextStyle() {
		return defaultTextStyle().copy();
	}

	/**
	 * Style for constants.
	 * @return Style for constants.
	 */
	public TextStyle constantDefinitionTextStyle() {
		return defaultTextStyle().copy();
	}

	/**
	 * Style for imports.
	 * @return Style for imports.
	 */
	public TextStyle importTextStyle() {
		return explanationTextStyle();
	}

	/**
	 * Style for explanations.
	 * @return Style for explanations.
	 */
	public TextStyle explanationTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(GRAY);
		return tempTextStyle;
	}

	/**
	 * Default text style.
	 * @return Default text style.
	 */
	public TextStyle defaultTextStyle() {
		return new TextStyle();
	}
}
