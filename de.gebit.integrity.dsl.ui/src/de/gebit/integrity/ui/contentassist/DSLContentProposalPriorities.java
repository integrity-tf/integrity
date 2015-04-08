/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities;

import com.google.common.base.CharMatcher;

/**
 * A custom proposal priority implementation in order to adjust proposal priorities.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DSLContentProposalPriorities extends ContentProposalPriorities {

	/**
	 * Priority for enumeration literals.
	 */
	private static final int ENUM_LITERAL_PRIORITY = 600;

	/**
	 * Maximum score bonus awarded because of "distance". Distance is measured in dots required to reference the element
	 * in the shortest way - that is, after considering package imports. So if you need to write
	 * "anotherpackage.element" to access an element, it has a distance of one, while "element" would have a distance of
	 * zero and "outerpackage.anotherpackage.element" would be two.
	 */
	private static final int CROSS_REFERENCE_DISTANCE_BONUS_MAX = 10;

	/**
	 * Bonus awarded to the distance score if the element is in the local suite.
	 */
	private static final int CROSS_REFERENCE_IN_LOCAL_SUITE_BONUS = 50;

	/**
	 * Bonus awarded to the distance score if the element is in the local package.
	 */
	private static final int CROSS_REFERENCE_IN_LOCAL_PACKAGE_BONUS = 25;

	@Override
	protected void adjustPriority(ICompletionProposal aProposal, String aPrefix, int aPriority) {
		super.adjustPriority(aProposal, aPrefix, aPriority);

		if (aProposal instanceof IntegrityConfigurableCompletionProposal) {
			IntegrityConfigurableCompletionProposal tempProposal = (IntegrityConfigurableCompletionProposal) aProposal;

			EObject tempAdditionalInfo = tempProposal.getAdditionalProposalInfoObject();

			// issue #84: enum literals should be prioritized
			if (tempAdditionalInfo instanceof JvmEnumerationLiteral) {
				tempProposal.setPriority(ENUM_LITERAL_PRIORITY);
			}

			// Only do the following if we have an element of our DSL model. Don't know any other way to find this out
			// other than checking whether we NOT have a JVM element reference.
			if (!(tempAdditionalInfo instanceof JvmIdentifiableElement)) {
				// Prioritize primarily by "distance" to the local position. This is done by calculating a distance
				// score (higher is better) and adding it to the priority.
				int tempCrossReferenceDistance = CharMatcher.is('.').countIn(tempProposal.getReplacementString());
				int tempCrossReferenceDistanceScore = CROSS_REFERENCE_DISTANCE_BONUS_MAX - tempCrossReferenceDistance;
				if (tempCrossReferenceDistanceScore < 0) {
					tempCrossReferenceDistanceScore = 0;
				}

				if (tempProposal.isReferencingObjectInLocalPackage()) {
					if (tempProposal.isReferencingObjectInLocalSuite()) {
						tempCrossReferenceDistanceScore += CROSS_REFERENCE_IN_LOCAL_SUITE_BONUS;
					} else {
						tempCrossReferenceDistanceScore += CROSS_REFERENCE_IN_LOCAL_PACKAGE_BONUS;
					}
				}

				tempProposal.setPriority(tempProposal.getPriority() + tempCrossReferenceDistanceScore);
			}
		}
	}
}
