/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.modelsource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Default implementation of a {@link ModelSourceExplorer}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultModelSourceExplorer implements ModelSourceExplorer {

	@Override
	public String determineSourceFilePath(EObject aModelElement) {
		return determineSourceFilePath(findNode(aModelElement));
	}

	/**
	 * Finds the source file path for a given {@link ICompositeNode} and cleans it up, removing Xtext-specific stuff and
	 * resulting in a clean absolute path.
	 * 
	 * @param aNode
	 *            the node to investigate
	 * @return the path
	 */
	protected String determineSourceFilePath(ICompositeNode aNode) {
		String tempResource = aNode.getRootNode().getSemanticElement().eResource().getURI().toString();
		String tempUndesiredPrefix = "platform:/resource/";
		if (tempResource.startsWith(tempUndesiredPrefix)) {
			return tempResource.substring(tempUndesiredPrefix.length());
		} else {
			return tempResource;
		}
	}

	@Override
	public String determineSourceSnippet(EObject aModelElement) {
		return determineSourceSnippet(findNode(aModelElement));
	}

	/**
	 * Finds the source snippet matching a given {@link ICompositeNode}.
	 * 
	 * @param aNode
	 *            the node to investigate
	 * @return the source snippet
	 */
	protected String determineSourceSnippet(ICompositeNode aNode) {
		return aNode.getText();
	}

	@Override
	public int determineSourceLine(EObject aModelElement) {
		return determineSourceLine(findNode(aModelElement));
	}

	/**
	 * Finds the line number in the source file matching a given {@link ICompositeNode}.
	 * 
	 * @param aNode
	 *            the node to investigate
	 * @return the line number
	 */
	protected int determineSourceLine(ICompositeNode aNode) {
		return aNode.getStartLine();
	}

	@Override
	public ModelSourceInformationElement determineSourceInformation(EObject aModelElement) {
		ICompositeNode tempNode = findNode(aModelElement);
		return new ModelSourceInformationElement(determineSourceSnippet(tempNode), determineSourceFilePath(tempNode),
				determineSourceLine(tempNode));
	}

	/**
	 * Finds the node conforming to a given model element. This will never return null, but throw an
	 * {@link IllegalArgumentException} instead, if no node could be found.
	 * 
	 * @param aModelElement
	 *            the model element to investigate
	 * @return the node
	 */
	protected ICompositeNode findNode(EObject aModelElement) {
		ICompositeNode tempNode = NodeModelUtils.getNode(aModelElement);

		if (tempNode == null) {
			throw new IllegalArgumentException("No Node found for EObject " + aModelElement);
		}

		return tempNode;
	}

}
