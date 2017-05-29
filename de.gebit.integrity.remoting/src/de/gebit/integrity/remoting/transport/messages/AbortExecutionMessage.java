/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is sent from a server to all clients when its test running process has been aborted out of order. The
 * server will most likely disconnect all the clients immediately afterwards - clients should expect this to happen.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AbortExecutionMessage extends AbstractMessage {

	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = 423412341234132431L;

	/**
	 * The message of the AbortExecutionException.
	 */
	private String exceptionMessage;

	/**
	 * The stacktrace of the AbortExecutionException.
	 */
	private String exceptionStackTrace;

	/**
	 * Creates a new message.
	 * 
	 * @param anExceptionMessage
	 *            The message of the AbortExecutionException
	 * @param anExceptionStackTrace
	 *            The stacktrace of the AbortExecutionException
	 */
	public AbortExecutionMessage(String anExceptionMessage, String anExceptionStackTrace) {
		super();
		this.exceptionMessage = anExceptionMessage;
		this.exceptionStackTrace = anExceptionStackTrace;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public AbortExecutionMessage() {
		// no-arg constructor
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

}
