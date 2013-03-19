/**
 * 
 */
package de.gebit.integrity.bindings.swing;

/**
 * Base class for all special exceptions used in the Swing Bindings for Integrity.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegritySwingBindingsException extends Exception {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 3204821991129408837L;

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the message
	 * 
	 * @param aCause
	 *            the cause
	 */
	public IntegritySwingBindingsException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the message
	 */
	public IntegritySwingBindingsException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates an instance.
	 */
	public IntegritySwingBindingsException() {
		super();
	}

	/**
	 * Creates an instance.
	 * 
	 * @param aCause
	 *            the cause
	 */
	public IntegritySwingBindingsException(Throwable aCause) {
		super(aCause);
	}

}
