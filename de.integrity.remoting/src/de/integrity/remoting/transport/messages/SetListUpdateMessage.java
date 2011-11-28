package de.integrity.remoting.transport.messages;

import de.integrity.remoting.entities.setlist.SetListEntry;

public class SetListUpdateMessage extends AbstractMessage {

	private SetListEntry updatedEntries[];

	public SetListUpdateMessage(SetListEntry... someUpdatedEntries) {
		updatedEntries = someUpdatedEntries;
	}

	public SetListEntry[] getUpdatedEntries() {
		return updatedEntries;
	}

}
