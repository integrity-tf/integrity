/**
 * 
 */
package de.gebit.integrity.bindings.swing;

/**
 * Thrown if the {@link EventQueueSynchronizer} has hit a timeout. The queue was not finished processing all events
 * until the given time has elapsed.
 * 
 * @author Rene Schneider
 * 
 */
public class EventQueueTimeoutException extends Exception {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -3382642663497141811L;

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the error message
	 */
	public EventQueueTimeoutException(String aMessage) {
		super(aMessage);
	}

}
