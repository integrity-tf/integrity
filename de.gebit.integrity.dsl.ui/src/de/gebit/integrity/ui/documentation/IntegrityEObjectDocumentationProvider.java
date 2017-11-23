/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.documentation;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.shared.internal.Activator;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.ui.utils.JavadocUtil;
import de.gebit.integrity.utils.ParsedDocumentationComment;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;

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
	 * The model source explorer.
	 */
	@Inject
	ModelSourceExplorer modelSourceExplorer;

	/**
	 * Returns the documentation text for a specific object.
	 */
	@SuppressWarnings("restriction")
	@Override
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
			} else if (anObjectOrProxy instanceof SuiteDefinition) {
				SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObjectOrProxy;
				try {
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempSuiteDefinition.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempSuiteDefinition));
					return tempParsedComment.getDocumentationText();
				} catch (ParseException exc) {
					Activator.getDefault().getLog().log(new Status(Status.ERROR, "de.gebit.integrity.dsl.ui",
							"An exception was caught during documentation comment parsing", exc));
				}
			}
		}

		return null;
	}

}
