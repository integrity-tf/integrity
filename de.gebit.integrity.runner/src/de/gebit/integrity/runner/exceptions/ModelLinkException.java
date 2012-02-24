package de.gebit.integrity.runner.exceptions;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Thrown if any {@link EObject}s remain unresolvable during model linking. This may be caused by missing .integrity
 * files or unresolvable classes.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ModelLinkException extends ModelLoadException {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -4130208565392649148L;

	/**
	 * The objects that were not resolvable.
	 */
	private Set<EObject> unresolvableObjects;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param someUnresolvableObjects
	 *            the unresolvable objects
	 */
	public ModelLinkException(String aMessage, Set<EObject> someUnresolvableObjects) {
		super(aMessage);
		unresolvableObjects = someUnresolvableObjects;
	}

	public Set<EObject> getUnresolvableObjects() {
		return unresolvableObjects;
	}

}
