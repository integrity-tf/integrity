/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

/**
 * Interface for message processors. A message processor is called on the client or the server to process an incoming
 * message, thus it is linked to a specific message type.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 * @param <M>
 *            the message type
 */
public interface MessageProcessor<M extends AbstractMessage> {

	/**
	 * Process the message.
	 * 
	 * @param aMessage
	 *            the message to process
	 * @param anEndpoint
	 *            the endpoint which received the message
	 */
	void processMessage(M aMessage, Endpoint anEndpoint);

}
