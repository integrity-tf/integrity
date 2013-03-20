/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.actions;

import org.eclipse.jface.action.Action;

/**
 * Uses an Integrity URL to jump to a specific link.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class JumpToLinkAction extends Action {

	/**
	 * The URL.
	 */
	private String url;

	/**
	 * Creates a new instance.
	 * 
	 * @param anURL
	 *            the URL for the jump
	 * @param aText
	 *            the action text
	 * @param aToolTipText
	 *            the tooltip description for the action
	 */
	public JumpToLinkAction(String anURL, String aText, String aToolTipText) {
		url = anURL;
		setText(aText);
		setToolTipText(aToolTipText);
	}

	protected String getURL() {
		return url;
	}

}
