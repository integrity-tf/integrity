/**
 * 
 */
package de.gebit.integrity.exceptions;

/**
 * This exception is thrown in various situations which "should never happen", that is, situations in which all other
 * execution paths should technically cover all possible alternatives, but one cannot mathematically guarantee that this
 * is actually the case, or in which future extensions might open up new code paths not detectable by Eclipse.
 * 
 * @author Rene Schneider
 * 
 */
public class ThisShouldNeverHappenException extends IllegalStateException {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 8591527326536869557L;

	/**
	 * The standard constructor. If you don't really need to customize the message, just use this one.
	 */
	public ThisShouldNeverHappenException() {
		super("Congratulations - you have reached a state that should have been impossible to reach! "
				+ "This is most likely a serious bug in Integrity, please report it so it can be fixed.");
	}

	/**
	 * A constructor for a custom message.
	 * 
	 * @param aMessage
	 *            the message
	 */
	public ThisShouldNeverHappenException(String aMessage) {
		super(aMessage);
	}

}
