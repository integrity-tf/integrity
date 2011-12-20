package de.gebit.integrity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * A custom URI Resolver.
 * 
 * @author Rene Schneider
 * 
 */
public class DSLImportUriResolver extends ImportUriResolver {

	@Override
	public String resolve(EObject anObject) {
		return "platform:/resource/" + super.resolve(anObject) + ".testdsl";
	}

}
