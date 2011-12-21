package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetListEntry;

/**
 * Updates the setlist incrementally (with one or more updated entries).
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
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
