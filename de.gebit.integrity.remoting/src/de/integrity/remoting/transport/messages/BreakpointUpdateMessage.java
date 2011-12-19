package de.integrity.remoting.transport.messages;

import de.integrity.remoting.transport.enums.BreakpointActions;

public class BreakpointUpdateMessage extends AbstractMessage {

	private BreakpointActions action;

	private int entryReference;

	public BreakpointUpdateMessage(BreakpointActions anAction, int anEntryReference) {
		action = anAction;
		entryReference = anEntryReference;
	}

	public BreakpointActions getAction() {
		return action;
	}

	public int getEntryReference() {
		return entryReference;
	}

}
