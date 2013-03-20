/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.search.IXtextEObjectSearch;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * The default implementation of {@link IntegritySearch}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultIntegritySearch implements IntegritySearch {

	/**
	 * The XText search engine that's used to back the Integrity-specific search features.
	 */
	@Inject
	private IXtextEObjectSearch searchEngine;

	/**
	 * Opens XText editors based on Ecore URIs.
	 */
	@Inject
	private IURIEditorOpener uriEditorOpener;

	@Override
	public SuiteDefinition[] findSuiteDefinitionByName(String aSuiteName) {
		List<SuiteDefinition> tempResult = new ArrayList<SuiteDefinition>();

		for (IEObjectDescription tempDesc : searchEngine.findMatches(aSuiteName, SuiteDefinition.class.getSimpleName())) {
			EObject tempObject = tempDesc.getEObjectOrProxy();
			if (tempObject instanceof SuiteDefinition) {
				SuiteDefinition tempDefinition = (SuiteDefinition) tempObject;
				tempResult.add(tempDefinition);
			}
		}

		if (tempResult.size() > 0) {
			return tempResult.toArray(new SuiteDefinition[tempResult.size()]);
		} else {
			return null;
		}
	}

	@Override
	public IEditorPart openSuiteDefinitionByName(String aSuiteName) {
		SuiteDefinition[] tempSuiteDef = findSuiteDefinitionByName(aSuiteName);
		if (tempSuiteDef != null) {
			return uriEditorOpener.open(EcoreUtil.getURI(tempSuiteDef[0]), true);
		} else {
			return null;
		}
	}
}
