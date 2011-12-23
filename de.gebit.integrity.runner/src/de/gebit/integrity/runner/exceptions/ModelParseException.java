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

	private static final long serialVersionUID = -900276999311118806L;

	private List<Diagnostic> errors;

	public ModelParseException(String aMessage, List<Diagnostic> someErrors) {
		super(aMessage);
		errors = someErrors;
	}

	public List<Diagnostic> getErrors() {
		return errors;
	}

}
