package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetListEntry;

public class SetListUpdateMessage extends AbstractMessage {

	private static final long serialVersionUID = -8484484019443736840L;

	private SetListEntry updatedEntries[];

	private Integer entryInExecution;

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
