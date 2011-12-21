package de.gebit.integrity.remoting.transport;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

/**
 * Interface for message processors. A message processor is called on the client or the server to process an incoming
 * message, thus it is linked to a specific message type.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
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
