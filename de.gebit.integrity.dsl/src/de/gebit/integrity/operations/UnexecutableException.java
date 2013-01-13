/**
 * 
 */
package de.gebit.integrity.operations;

/**
 * This exception is thrown if an operation cannot be executed (usually because it depends on variables which are
 * not resolvable because no variable map was given).
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class UnexecutableException extends Exception {

	/**
	 * The serialization version.
	 */
	private static final long serialVersionUID = -6492533441071927015L;

	/**
	 * Instantiates a new unexecutable exception.
	 */
	public UnexecutableException() {
		super();
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aMessage
	 *            the a message
	 * @param aCause
	 *            the a cause
	 */
	public UnexecutableException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aMessage
	 *            the a message
	 */
	public UnexecutableException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aCause
	 *            the a cause
	 */
	public UnexecutableException(Throwable aCause) {
		super(aCause);
	}

}