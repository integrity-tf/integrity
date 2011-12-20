package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.BreakpointActions;

public class BreakpointUpdateMessage extends AbstractMessage {

	private static final long serialVersionUID = -5884158701301953627L;

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
