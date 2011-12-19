package de.gebit.integrity.runner.exceptions;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

public class ModelParseException extends ModelLoadException {

	private List<Diagnostic> errors;

	public ModelParseException(String aMessage, List<Diagnostic> someErrors) {
		super(aMessage);
		errors = someErrors;
	}

	public List<Diagnostic> getErrors() {
		return errors;
	}

}
