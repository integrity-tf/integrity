/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities;

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

	@Override
	protected void adjustPriority(ICompletionProposal aProposal, String aPrefix, int aPriority) {
		super.adjustPriority(aProposal, aPrefix, aPriority);

		if (aProposal instanceof IntegrityConfigurableCompletionProposal) {
			IntegrityConfigurableCompletionProposal tempProposal = (IntegrityConfigurableCompletionProposal) aProposal;

			Object tempAdditionalInfo = tempProposal.getAdditionalProposalInfo(null);
			if (tempAdditionalInfo instanceof JvmEnumerationLiteral) {
				tempProposal.setPriority(ENUM_LITERAL_PRIORITY);
			}
		}
	}

}
