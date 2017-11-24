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
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.shared.internal.Activator;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.ui.utils.JavadocUtil;
import de.gebit.integrity.utils.ParsedDocumentationComment;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;

/**
 * The custom hover provider.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("restriction")
public class IntegrityEObjectHoverProvider extends DefaultEObjectHoverProvider {

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

	@Override
	protected boolean hasHover(EObject anObject) {
		try {
			if (anObject instanceof TestDefinition) {
				TestDefinition tempTestDefinition = (TestDefinition) anObject;
				if (tempTestDefinition.getDocumentation() != null) {
					return true;
				} else {
					// Try a fallback to the javadoc of the fixture method
					if (tempTestDefinition.getFixtureMethod() != null
							&& tempTestDefinition.getFixtureMethod().getMethod() != null) {
						String tempJavadoc = JavadocUtil
								.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(), elementFinder);
						return tempJavadoc != null;
					}
				}
			} else if (anObject instanceof CallDefinition) {
				CallDefinition tempCallDefinition = (CallDefinition) anObject;
				if (tempCallDefinition.getDocumentation() != null) {
					return true;
				} else {
					// Try a fallback to the javadoc of the fixture method
					if (tempCallDefinition.getFixtureMethod() != null
							&& tempCallDefinition.getFixtureMethod().getMethod() != null) {
						String tempJavadoc = JavadocUtil
								.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(), elementFinder);
						return tempJavadoc != null;
					}
				}
			} else if (anObject instanceof SuiteDefinition) {
				SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObject;
				return (tempSuiteDefinition.getDocumentation() != null);
			} else if (anObject instanceof VariableEntity) {
				if (anObject.eContainer() instanceof SuiteParameterDefinition) {
					SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObject.eContainer().eContainer();
					if (tempSuiteDefinition.getDocumentation() != null) {
						ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
								tempSuiteDefinition.getDocumentation(),
								modelSourceExplorer.determineSourceInformation(tempSuiteDefinition.getDocumentation()));
						return tempParsedComment.getParameterDocumentationTexts()
								.containsKey(((VariableEntity) anObject).getName());
					}
				}
			} else if (anObject instanceof ForkDefinition) {
				ForkDefinition tempForkDefinition = (ForkDefinition) anObject;
				return (tempForkDefinition.getDocumentation() != null);
			} else if (anObject instanceof VariantDefinition) {
				VariantDefinition tempVariantDefinition = (VariantDefinition) anObject;
				return (tempVariantDefinition.getDocumentation() != null);
			} else if (anObject instanceof ConstantEntity && anObject.eContainer() instanceof ConstantDefinition) {
				ConstantDefinition tempConstantDefinition = (ConstantDefinition) anObject.eContainer();
				return (tempConstantDefinition.getDocumentation() != null);
			}
		} catch (ParseException exc) {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, "de.gebit.integrity.dsl.ui",
					"An exception was caught during documentation comment parsing", exc));
		}

		return false;
	}

}
