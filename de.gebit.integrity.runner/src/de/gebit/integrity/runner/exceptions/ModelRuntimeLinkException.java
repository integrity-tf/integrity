package de.gebit.integrity.runner.exceptions;

import org.eclipse.emf.ecore.EObject;

/**
 * Thrown if any {@link EObject}s remain unresolvable during runtime resolving of EMF proxies. This may be caused by
 * missing .integrity files or unresolvable classes.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ModelRuntimeLinkException extends RuntimeException {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -4130208565392649148L;

	/**
	 * The unresolvable object.
	 */
	private EObject unresolvableObject;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param anUnresolvableObject
	 *            the unresolvable object
	 */
	public ModelRuntimeLinkException(String aMessage, EObject anUnresolvableObject) {
		super(aMessage);
		unresolvableObject = anUnresolvableObject;
	}

	public EObject getUnresolvableObject() {
		return unresolvableObject;
	}

}
