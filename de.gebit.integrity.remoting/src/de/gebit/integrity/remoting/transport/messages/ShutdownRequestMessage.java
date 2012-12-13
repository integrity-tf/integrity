package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is sent by the client to request a shutdown.
 * 
 * @author Rene Schneider
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
