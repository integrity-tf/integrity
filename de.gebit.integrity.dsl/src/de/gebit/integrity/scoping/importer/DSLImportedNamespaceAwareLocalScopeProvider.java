/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.scoping.importer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * This namespace-aware local scope provider modifies the default scope provider from XText just slightly: it sorts the
 * {@link ImportNormalizer} list to be returned such that normalizers with more segments are placed first. XText always
 * uses the first match when normalizing an imported resource reference, thus if a package is imported by one less and
 * one more specific import statement, the more specific one will be used regardless of the order of import statements,
 * which results in the shortest possible normalized resource reference.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject aContext, boolean anIgnoreCaseFlag) {
		List<ImportNormalizer> tempList = super.internalGetImportedNamespaceResolvers(aContext, anIgnoreCaseFlag);

		Collections.sort(tempList, new Comparator<ImportNormalizer>() {

			@Override
			public int compare(ImportNormalizer aFirstObject, ImportNormalizer aSecondObject) {
				return aSecondObject.getImportedNamespacePrefix().getSegmentCount()
						- aFirstObject.getImportedNamespacePrefix().getSegmentCount();
			}
		});

		return tempList;
	}
}
