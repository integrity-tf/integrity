/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.ui.utils.JavadocUtil;

/**
 * The custom hover provider.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityEObjectHoverProvider extends DefaultEObjectHoverProvider {

	/**
	 * The element finder.
	 */
	@Inject
	IJavaElementFinder elementFinder;

	@Override
	protected boolean hasHover(EObject anObject) {
		if (anObject instanceof TestDefinition) {
			TestDefinition tempTestDefinition = (TestDefinition) anObject;
			if (tempTestDefinition.getFixtureMethod() != null
					&& tempTestDefinition.getFixtureMethod().getMethod() != null) {
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc != null;
			}
		} else if (anObject instanceof CallDefinition) {
			CallDefinition tempCallDefinition = (CallDefinition) anObject;
			if (tempCallDefinition.getFixtureMethod() != null
					&& tempCallDefinition.getFixtureMethod().getMethod() != null) {
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc != null;
			}
		} else if (anObject instanceof SuiteDefinition) {
			SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObject;
			return (tempSuiteDefinition.getDocumentation() != null);
		}

		return false;
	}

}
