package de.gebit.integrity.runner.exceptions;

/**
 * Basic exception for errors during model loading.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ModelLoadException extends Exception {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 2536057162116739387L;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 */
	public ModelLoadException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param aNestedException
	 *            the nested exception
	 */
	public ModelLoadException(String aMessage, Throwable aNestedException) {
		super(aMessage, aNestedException);
	}

}
