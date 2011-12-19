package de.integrity.remoting.transport;

import de.integrity.remoting.transport.messages.AbstractMessage;

public interface MessageProcessor<M extends AbstractMessage> {

	void processMessage(M aMessage, Endpoint anEndpoint);

}
