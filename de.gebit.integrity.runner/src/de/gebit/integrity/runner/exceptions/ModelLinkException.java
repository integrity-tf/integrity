package de.gebit.integrity.runner.exceptions;

import java.io.PrintStream;
import java.util.Iterator;
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

	/**
	 * Prints a readable list of all unresolvable objects to {@link System.err}.
	 */
	public void printUnresolvableObjects() {
		printUnresolvableObjects(System.err);
	}

	/**
	 * Prints a readable list of all unresolvable objects to the given stream.
	 * 
	 * @param aTargetStream
	 *            the target stream
	 */
	public void printUnresolvableObjects(PrintStream aTargetStream) {
		Iterator<EObject> tempIter = getUnresolvableObjects().iterator();
		while (tempIter.hasNext()) {
			EObject tempUnresolved = tempIter.next();
			aTargetStream.println("Unresolved reference: " + tempUnresolved);
		}
	}

}
