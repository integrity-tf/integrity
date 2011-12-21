package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionStates;

/**
 * Sent to inform clients about changes in the execution state.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class ExecutionStateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 3437600335397554935L;

	/**
	 * The new execution state.
	 */
	private ExecutionStates state;

	/**
	 * Creates a new message.
	 * 
	 * @param aState
	 *            the new execution state
	 */
	public ExecutionStateMessage(ExecutionStates aState) {
		state = aState;
	}

	public ExecutionStates getState() {
		return state;
	}

}
