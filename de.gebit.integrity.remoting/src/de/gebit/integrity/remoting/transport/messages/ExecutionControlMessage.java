/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;

/**
 * This message is sent by the client to control test execution.
 * 
 * @author Rene Schneider - initial API and implementation
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
