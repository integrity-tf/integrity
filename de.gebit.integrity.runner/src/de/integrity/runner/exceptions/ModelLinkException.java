package de.integrity.runner.exceptions;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class ModelLinkException extends ModelLoadException {

	private Set<EObject> unresolvableObjects;

	public ModelLinkException(String aMessage, Set<EObject> someUnresolvableObjects) {
		super(aMessage);
		unresolvableObjects = someUnresolvableObjects;
	}

	public Set<EObject> getUnresolvableObjects() {
		return unresolvableObjects;
	}

}
