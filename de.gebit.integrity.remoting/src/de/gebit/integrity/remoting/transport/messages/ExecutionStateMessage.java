package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionStates;

public class ExecutionStateMessage extends AbstractMessage {

	private static final long serialVersionUID = 3437600335397554935L;

	private ExecutionStates state;

	public ExecutionStateMessage(ExecutionStates aState) {
		state = aState;
	}

	public ExecutionStates getState() {
		return state;
	}

}
