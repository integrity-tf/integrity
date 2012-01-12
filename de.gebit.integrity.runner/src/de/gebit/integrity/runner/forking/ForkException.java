/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ForkException extends Exception {

	public ForkException() {
		super();
	}

	public ForkException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	public ForkException(String aMessage) {
		super(aMessage);
	}

	public ForkException(Throwable aCause) {
		super(aCause);
	}

}
