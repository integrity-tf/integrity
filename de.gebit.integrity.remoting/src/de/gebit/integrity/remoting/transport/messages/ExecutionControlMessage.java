package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;

public class ExecutionControlMessage extends AbstractMessage {

	private static final long serialVersionUID = 4477656880432601853L;

	private ExecutionCommands command;

	public ExecutionControlMessage(ExecutionCommands aCommand) {
		command = aCommand;
	}

	public ExecutionCommands getCommand() {
		return command;
	}

}
