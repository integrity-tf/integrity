/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.exceptions;

import org.eclipse.emf.ecore.EObject;

import de.gebit.integrity.modelsource.ModelSourceInformationElement;

/**
 * Thrown if any {@link EObject}s remain unresolvable during runtime resolving of EMF proxies. This may be caused by
 * missing .integrity files or unresolvable classes.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * The model source information, if available.
	 */
	private ModelSourceInformationElement modelSourceInfo;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param anUnresolvableObject
	 *            the unresolvable object
	 */
	public ModelRuntimeLinkException(String aMessage, EObject anUnresolvableObject,
			ModelSourceInformationElement aModelSourceInfo) {
		super((aModelSourceInfo != null ? aModelSourceInfo + " - " : "") + aMessage);
		unresolvableObject = anUnresolvableObject;
		modelSourceInfo = aModelSourceInfo;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param anUnresolvableObject
	 *            the unresolvable object
	 * @param aCause
	 *            the cause
	 */
	public ModelRuntimeLinkException(String aMessage, EObject anUnresolvableObject,
			ModelSourceInformationElement aModelSourceInfo, Throwable aCause) {
		super((aModelSourceInfo != null ? aModelSourceInfo + " - " : "") + aMessage, aCause);
		unresolvableObject = anUnresolvableObject;
		unresolvableObject = anUnresolvableObject;
		modelSourceInfo = aModelSourceInfo;
	}

	public EObject getUnresolvableObject() {
		return unresolvableObject;
	}

	public ModelSourceInformationElement getModelSourceInfo() {
		return modelSourceInfo;
	}

}
