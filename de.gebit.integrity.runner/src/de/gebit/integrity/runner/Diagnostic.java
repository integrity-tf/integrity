/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;

import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;

/**
 * This is basically a unification of org.eclipse.emf.common.util.Diagnostic and
 * org.eclipse.emf.ecore.resource.Resource.Diagnostic.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class Diagnostic {

	/**
	 * The location where the error was found, in the form of a string. This is always available.
	 */
	private String location;

	/**
	 * The location where the error was found. Optional.
	 */
	private ModelSourceInformationElement locationInfo;

	/**
	 * The {@link EObject} which was found to be erroneous. Optional.
	 */
	private EObject eObject;

	/**
	 * The error message. Always available.
	 */
	private String message;

	/**
	 * Constructs a new instance.
	 * 
	 * @param aLocation
	 *            the location of the error
	 * @param aMessage
	 *            the error message
	 */
	public Diagnostic(String aLocation, String aMessage) {
		location = aLocation;
		message = aMessage;
	}

	/**
	 * Constructs a new instance based on an existing diagnostic object.
	 * 
	 * @param aDiagnostic
	 */
	public Diagnostic(org.eclipse.emf.ecore.resource.Resource.Diagnostic aDiagnostic) {
		location = aDiagnostic.getLocation();
		message = aDiagnostic.getMessage();
	}

	/**
	 * Constructs a new instance based on an existing diagnostic object.
	 * 
	 * @param aDiagnostic
	 * @param aSourceExplorer
	 *            the model source explorer (optional; location info will not be as detailed if not provided)
	 */
	public Diagnostic(org.eclipse.emf.common.util.Diagnostic aDiagnostic, ModelSourceExplorer aSourceExplorer) {
		location = aDiagnostic.getSource();
		if (aDiagnostic instanceof AbstractValidationDiagnostic) {
			eObject = ((AbstractValidationDiagnostic) aDiagnostic).getSourceEObject();
			if (eObject != null && aSourceExplorer != null) {
				locationInfo = aSourceExplorer.determineSourceInformation(eObject);
				if (locationInfo != null) {
					location = locationInfo.getFilePath() + ":" + locationInfo.getLineNumber();
				}
			}
		}
		message = aDiagnostic.getMessage();
	}

	public String getLocation() {
		return location;
	}

	public ModelSourceInformationElement getLocationInfo() {
		return locationInfo;
	}

	public EObject getEObject() {
		return eObject;
	}

	public String getMessage() {
		return message;
	}

}
