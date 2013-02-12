/**
 * 
 */
package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is sent back and forth between two endpoints when one of them wants to close the connection. Its purpose
 * is to prevent any actual message bytes from getting lost in the close process, which can happen if a socket is closed
 * while there are still bytes to be written in the buffer (a common Java socket problem).
 * 
 * @author Rene Schneider
 * 
 */
public class DisconnectMessage extends AbstractMessage {

	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = -1541164123991832022L;

	/**
	 * Set to true if this message is a confirmation (response to disconnect request message). False means this is a
	 * request and should be answered by a disconnect confirm message.
	 */
	private boolean confirmation;

	/**
	 * Creates a new instance.
	 * 
	 * @param anIsConfirmation
	 *            whether this is a confirmation message
	 */
	public DisconnectMessage(boolean anIsConfirmation) {
		confirmation = anIsConfirmation;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

}
