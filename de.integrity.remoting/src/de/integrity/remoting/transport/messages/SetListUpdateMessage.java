package de.integrity.remoting.transport.messages;

import de.integrity.remoting.entities.setlist.SetListEntry;

public class SetListUpdateMessage extends AbstractMessage {

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
