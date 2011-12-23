package de.gebit.integrity.runner.exceptions;

/**
 * Basic exception for errors during model loading.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ModelLoadException extends Exception {

	private static final long serialVersionUID = 2536057162116739387L;

	public ModelLoadException(String aMessage) {
		super(aMessage);
	}

	public ModelLoadException(String aMessage, Throwable aNestedException) {
		super(aMessage, aNestedException);
	}

}
