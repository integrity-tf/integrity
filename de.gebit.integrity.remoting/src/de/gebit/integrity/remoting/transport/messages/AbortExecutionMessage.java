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

	private String exceptionMessage;

	private String exceptionStackTrace;

	public AbortExecutionMessage(String anExceptionMessage, String anExceptionStackTrace) {
		super();
		this.exceptionMessage = anExceptionMessage;
		this.exceptionStackTrace = anExceptionStackTrace;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

}
