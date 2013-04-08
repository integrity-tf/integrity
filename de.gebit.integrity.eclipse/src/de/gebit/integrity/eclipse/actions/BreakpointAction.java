/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.actions;

import org.eclipse.jface.action.Action;

/**
 * Creates a breakpoint at a specified set list entry.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class BreakpointAction extends Action {

	/**
	 * The ID of the entry at which the breakpoint shall be created.
	 */
	private int entryReference;

	/**
	 * Creates a new instance.
	 * 
	 * @param anEntryReference
	 *            the reference to the set list entry at which the breakpoint shall be created
	 * @param aText
	 *            the action text
	 * @param aToolTipText
	 *            the tooltip description for the action
	 */
	public BreakpointAction(int anEntryReference, String aText, String aToolTipText) {
		entryReference = anEntryReference;
		setText(aText);
		setToolTipText(aToolTipText);
	}

	protected int getEntryReference() {
		return entryReference;
	}

}
