package de.gebit.integrity.runner.exceptions;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * Exception thrown if any errors appear during parsing of the data model.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ModelParseException extends ModelLoadException {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -900276999311118806L;

	/**
	 * The errors that occurred during parsing.
	 */
	private List<Diagnostic> errors;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param someErrors
	 *            the errors occurring during parsing
	 */
	public ModelParseException(String aMessage, List<Diagnostic> someErrors) {
		super(aMessage);
		errors = someErrors;
	}

	public List<Diagnostic> getErrors() {
		return errors;
	}

}
