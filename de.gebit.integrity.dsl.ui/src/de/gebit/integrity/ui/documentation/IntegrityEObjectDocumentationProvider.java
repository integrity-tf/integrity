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
 * The documentation provider. This provides texts for quick help displays, like in mouseovers.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("restriction")
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
	@Override
	public String getDocumentation(EObject anObjectOrProxy) {
		try {
			if (!anObjectOrProxy.eIsProxy()) {
				if (anObjectOrProxy instanceof TestDefinition) {
					TestDefinition tempTestDefinition = (TestDefinition) anObjectOrProxy;
					if (tempTestDefinition.getDocumentation() != null) {
						ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
								tempTestDefinition.getDocumentation(),
								modelSourceExplorer.determineSourceInformation(tempTestDefinition.getDocumentation()));
						return tempParsedComment.getJavadocStyleFullDocumentation();
					} else {
						// Try a fallback to the javadoc of the fixture method
						String tempJavadoc = JavadocUtil
								.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(), elementFinder);
						return tempJavadoc;
					}
				} else if (anObjectOrProxy instanceof CallDefinition) {
					CallDefinition tempCallDefinition = (CallDefinition) anObjectOrProxy;
					if (tempCallDefinition.getDocumentation() != null) {
						ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
								tempCallDefinition.getDocumentation(),
								modelSourceExplorer.determineSourceInformation(tempCallDefinition.getDocumentation()));
						return tempParsedComment.getJavadocStyleFullDocumentation();
					} else {
						// Try a fallback to the javadoc of the fixture method
						String tempJavadoc = JavadocUtil
								.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(), elementFinder);
						return tempJavadoc;
					}
				} else if (anObjectOrProxy instanceof SuiteDefinition) {
					SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObjectOrProxy;
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempSuiteDefinition.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempSuiteDefinition.getDocumentation()));
					return tempParsedComment.getDocumentationText();
				} else if (anObjectOrProxy instanceof VariableEntity) {
					if (anObjectOrProxy.eContainer() instanceof SuiteParameterDefinition) {
						SuiteDefinition tempSuiteDefinition = (SuiteDefinition) anObjectOrProxy.eContainer()
								.eContainer();
						if (tempSuiteDefinition.getDocumentation() != null) {
							ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
									tempSuiteDefinition.getDocumentation(),
									modelSourceExplorer.determineSourceInformation(tempSuiteDefinition));
							return tempParsedComment.getParameterDocumentationTexts()
									.get(((VariableEntity) anObjectOrProxy).getName());
						}
					}
				} else if (anObjectOrProxy instanceof ForkDefinition) {
					ForkDefinition tempForkDefinition = (ForkDefinition) anObjectOrProxy;
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempForkDefinition.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempForkDefinition.getDocumentation()));
					return tempParsedComment.getDocumentationText();
				} else if (anObjectOrProxy instanceof VariantDefinition) {
					VariantDefinition tempVariantDefinition = (VariantDefinition) anObjectOrProxy;
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempVariantDefinition.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempVariantDefinition.getDocumentation()));
					return tempParsedComment.getDocumentationText();
				} else if (anObjectOrProxy instanceof ConstantEntity
						&& anObjectOrProxy.eContainer() instanceof ConstantDefinition) {
					ConstantDefinition tempConstantDefinition = (ConstantDefinition) anObjectOrProxy.eContainer();
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempConstantDefinition.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempConstantDefinition.getDocumentation()));
					return tempParsedComment.getDocumentationText();
				}
			}
		} catch (ParseException exc) {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, "de.gebit.integrity.dsl.ui",
					"An exception was caught during documentation comment parsing", exc));
		}

		return null;
	}

}
