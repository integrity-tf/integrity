package de.gebit.integrity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

public class DSLImportUriResolver extends ImportUriResolver {

	@Override
	public String resolve(EObject object) {
		return "platform:/resource/" + super.resolve(object) + ".testdsl";
	}

}
