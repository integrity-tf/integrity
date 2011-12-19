package de.integrity.runner.exceptions;


public class ModelLoadException extends Exception {

	public ModelLoadException(String aMessage) {
		super(aMessage);
	}

	public ModelLoadException(String aMessage, Throwable aNestedException) {
		super(aMessage, aNestedException);
	}

}
