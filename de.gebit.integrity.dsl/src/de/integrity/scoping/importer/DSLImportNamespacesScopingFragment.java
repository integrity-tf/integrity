package de.integrity.scoping.importer;

import org.eclipse.xtext.generator.scoping.ImportNamespacesScopingFragment;
import org.eclipse.xtext.scoping.IScopeProvider;

public class DSLImportNamespacesScopingFragment extends ImportNamespacesScopingFragment {

	@Override
	protected Class<? extends IScopeProvider> getLocalScopeProvider() {
		return DSLImportedNamespaceAwareLocalScopeProvider.class;
	}

}
