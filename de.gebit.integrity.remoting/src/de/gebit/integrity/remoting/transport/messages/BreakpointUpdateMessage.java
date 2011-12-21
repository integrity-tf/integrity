package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.BreakpointActions;

/**
 * This message is sent when breakpoints shall be created or removed. It is used both as notification about breakpoint
 * changes (server -> client) as well as requests (client -> server).
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class BreakpointUpdateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -5884158701301953627L;

	/**
	 * The action to perform.
	 */
	private BreakpointActions action;

	/**
	 * The entry reference on which to perform the action.
	 */
	private int entryReference;

	/**
	 * Creates a new message instance.
	 * 
	 * @param anAction
	 *            the action to perform
	 * @param anEntryReference
	 *            the entry reference on which to perform the action
	 */
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
