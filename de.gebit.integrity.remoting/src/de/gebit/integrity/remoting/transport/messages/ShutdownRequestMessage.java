/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is sent by the client to request a shutdown.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ShutdownRequestMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 6413804985542703382L;

	/**
	 * Creates a new message.
	 * 
	 */
	public ShutdownRequestMessage() {
		super();
	}

}
