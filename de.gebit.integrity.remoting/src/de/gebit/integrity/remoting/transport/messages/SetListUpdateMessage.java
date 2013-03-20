/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetListEntry;

/**
 * Updates the setlist incrementally (with one or more updated entries).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SetListUpdateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -8484484019443736840L;

	/**
	 * The updated entries.
	 */
	private SetListEntry[] updatedEntries;

	/**
	 * The entry in execution (may be null if not changed).
	 */
	private Integer entryInExecution;

	/**
	 * Creates a new instance.
	 * 
	 * @param anEntryInExecution
	 *            the entry in execution
	 * @param someUpdatedEntries
	 *            the updated entries
	 */
	public SetListUpdateMessage(Integer anEntryInExecution, SetListEntry... someUpdatedEntries) {
		entryInExecution = anEntryInExecution;
		updatedEntries = someUpdatedEntries;
	}

	public SetListEntry[] getUpdatedEntries() {
		return updatedEntries;
	}

	public Integer getEntryInExecution() {
		return entryInExecution;
	}

}
