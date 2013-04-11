/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.scoping.importer;

import org.eclipse.xtext.generator.scoping.ImportNamespacesScopingFragment;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * This fragment overrides the default scoping fragment provided by XText in order to override the scope provider.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLImportNamespacesScopingFragment extends ImportNamespacesScopingFragment {

	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return DSLImportedNamespaceAwareLocalScopeProvider.class;
	}

}
