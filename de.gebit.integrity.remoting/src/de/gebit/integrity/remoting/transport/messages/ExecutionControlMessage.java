package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;

/**
 * This message is sent by the client to control test execution.
 * 
 * @author Rene Schneider
 * 
 */
public class ExecutionControlMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 4477656880432601853L;

	/**
	 * The command to perform.
	 */
	private ExecutionCommands command;

	/**
	 * Creates a new message.
	 * 
	 * @param aCommand
	 *            the command to perform
	 */
	public ExecutionControlMessage(ExecutionCommands aCommand) {
		command = aCommand;
	}

	public ExecutionCommands getCommand() {
		return command;
	}

}
