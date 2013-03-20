/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * A custom URI Resolver.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLImportUriResolver extends ImportUriResolver {

	@Override
	public String resolve(EObject anObject) {
		return "platform:/resource/" + super.resolve(anObject) + ".testdsl";
	}

}
