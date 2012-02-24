/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * Thrown if forking failed.
 * 
 * @author Rene Schneider
 * 
 */
public class ForkException extends Exception {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 8054739284988979101L;

	/**
	 * Creates a new instance.
	 */
	public ForkException() {
		super();
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(Throwable aCause) {
		super(aCause);
	}

}
