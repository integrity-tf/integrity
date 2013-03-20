/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.ui.utils.JavadocUtil;

/**
 * The documentation provider. This provides texts for quick help displays, like in mouseovers.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityEObjectDocumentationProvider implements IEObjectDocumentationProvider {

	/**
	 * The element finder.
	 */
	@Inject
	IJavaElementFinder elementFinder;

	/**
	 * Returns the documentation text for a specific object.
	 */
	public String getDocumentation(EObject anObjectOrProxy) {
		if (!anObjectOrProxy.eIsProxy()) {
			if (anObjectOrProxy instanceof TestDefinition) {
				TestDefinition tempTestDefinition = (TestDefinition) anObjectOrProxy;
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc;
			} else if (anObjectOrProxy instanceof CallDefinition) {
				CallDefinition tempCallDefinition = (CallDefinition) anObjectOrProxy;
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc;
			}
		}

		return null;
	}

}
