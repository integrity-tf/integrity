package de.gebit.integrity.runner.exceptions;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class ModelLinkException extends ModelLoadException {

	private static final long serialVersionUID = -4130208565392649148L;

	private Set<EObject> unresolvableObjects;

	public ModelLinkException(String aMessage, Set<EObject> someUnresolvableObjects) {
		super(aMessage);
		unresolvableObjects = someUnresolvableObjects;
	}

	public Set<EObject> getUnresolvableObjects() {
		return unresolvableObjects;
	}

}
