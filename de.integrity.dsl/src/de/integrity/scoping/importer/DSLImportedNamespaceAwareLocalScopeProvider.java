package de.integrity.scoping.importer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

public class DSLImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		List<ImportNormalizer> tempList = super.internalGetImportedNamespaceResolvers(context, ignoreCase);

		Collections.sort(tempList, new Comparator<ImportNormalizer>() {

			@Override
			public int compare(ImportNormalizer o1, ImportNormalizer o2) {
				return o2.getImportedNamespacePrefix().getSegmentCount()
						- o1.getImportedNamespacePrefix().getSegmentCount();
			}
		});

		return tempList;
	}
}
