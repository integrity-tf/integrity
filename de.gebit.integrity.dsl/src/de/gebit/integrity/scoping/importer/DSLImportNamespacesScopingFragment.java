package de.gebit.integrity.scoping.importer;

import org.eclipse.xtext.generator.scoping.ImportNamespacesScopingFragment;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * This fragment overrides the default scoping fragment provided by XText in order to override the scope provider.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class DSLImportNamespacesScopingFragment extends ImportNamespacesScopingFragment {

	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return DSLImportedNamespaceAwareLocalScopeProvider.class;
	}

}
