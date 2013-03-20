/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetList;

/**
 * Updates the setlist with a new baseline, that is, a complete copy.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SetListBaselineMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 9085447162313871124L;

	/**
	 * The new setlist.
	 */
	private SetList setList;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the new setlist
	 */
	public SetListBaselineMessage(SetList aSetList) {
		setList = aSetList;
	}

	public SetList getSetList() {
		return setList;
	}

}
