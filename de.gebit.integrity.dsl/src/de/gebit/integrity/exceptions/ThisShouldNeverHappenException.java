/**
 * 
 */
package de.gebit.integrity.exceptions;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ThisShouldNeverHappenException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8591527326536869557L;

	public ThisShouldNeverHappenException() {
		super("Congratulations - you have reached a state that should have been impossible to reach! "
				+ "This is most likely a serious bug in Integrity, please report it so it can be fixed.");
	}

	public ThisShouldNeverHappenException(String aMessage) {
		super(aMessage);
	}

}
