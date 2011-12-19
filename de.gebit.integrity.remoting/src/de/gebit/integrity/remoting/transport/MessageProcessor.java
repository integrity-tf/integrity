package de.gebit.integrity.remoting.transport;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

public interface MessageProcessor<M extends AbstractMessage> {

	void processMessage(M aMessage, Endpoint anEndpoint);

}
