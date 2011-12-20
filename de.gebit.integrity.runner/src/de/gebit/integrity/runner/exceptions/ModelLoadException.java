package de.gebit.integrity.runner.exceptions;

public class ModelLoadException extends Exception {

	private static final long serialVersionUID = 2536057162116739387L;

	public ModelLoadException(String aMessage) {
		super(aMessage);
	}

	public ModelLoadException(String aMessage, Throwable aNestedException) {
		super(aMessage, aNestedException);
	}

}
