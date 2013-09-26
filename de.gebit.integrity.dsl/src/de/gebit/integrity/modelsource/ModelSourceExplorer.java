/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.modelsource;

import org.eclipse.emf.ecore.EObject;

/**
 * This service provides methods to reflect on Integrity test model elements and to get information about their
 * representations in the original script files.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ModelSourceExplorer {

	/**
	 * Finds the textual snippet from which a model element was originally parsed.
	 * 
	 * @param aModelElement
	 *            the element
	 * @return the snippet
	 */
	String determineSourceSnippet(EObject aModelElement);

	/**
	 * Finds the line in the original script file at which a certain element starts.
	 * 
	 * @param aModelElement
	 *            the element
	 * @return the line number
	 */
	int determineSourceLine(EObject aModelElement);

	/**
	 * Determines the full path to the source file in which a certain element is defined.
	 * 
	 * @param aModelElement
	 *            the element
	 * @return the file path
	 */
	String determineSourceFilePath(EObject aModelElement);

	/**
	 * Determines all information about the source of a model element at once.
	 * 
	 * @param aModelElement
	 *            the element
	 * @return the information container
	 */
	ModelSourceInformationElement determineSourceInformation(EObject aModelElement);

}
