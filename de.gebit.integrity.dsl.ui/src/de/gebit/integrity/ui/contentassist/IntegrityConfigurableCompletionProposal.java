/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

import com.google.inject.Provider;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;

/**
 * A context-aware configurable completion proposal. This proposal knows its content assist context and uses this in
 * order to resolve the EObject proxy if necessary on request of additional proposal info, but only if the fully
 * resolved object is necessary to display certain content assist info later (via
 * {@link de.gebit.integrity.ui.documentation.IntegrityEObjectDocumentationProvider}).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("restriction")
public class IntegrityConfigurableCompletionProposal extends ConfigurableCompletionProposal implements
		ICompletionProposalExtension3 {

	/**
	 * The context.
	 */
	private ContentAssistContext context;

	/**
	 * This is set if this proposal is suggesting a variable defined in a suite definition header (that is, a suite
	 * parameter). These are subject to a few specialties when it comes to proposals and scopes. If I one day find out
	 * how to model this construction a little more elegant, I'll do it. Until then this hack should do the job ;-).
	 */
	private SuiteDefinition suiteDefiningProposedParameter;

	/**
	 * Whether to use a HTML browser window to display the proposal info, if possible.
	 */
	private boolean useHtmlAdditionalProposalInfo;

	public void setUseHtmlAdditionalProposalInfo(boolean aUseHtmlAdditionalProposalInfoFlag) {
		this.useHtmlAdditionalProposalInfo = aUseHtmlAdditionalProposalInfoFlag;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aReplacementString
	 * @param aReplacementOffset
	 * @param aReplacementLength
	 * @param aCursorPosition
	 * @param anImage
	 * @param aDisplayString
	 * @param aContextInformation
	 * @param anAdditionalProposalInfo
	 */
	// SUPPRESS CHECKSTYLE ParameterNumber
	public IntegrityConfigurableCompletionProposal(String aReplacementString, int aReplacementOffset,
			int aReplacementLength, int aCursorPosition, Image anImage, StyledString aDisplayString,
			IContextInformation aContextInformation, ContentAssistContext aContext) {
		super(aReplacementString, aReplacementOffset, aReplacementLength, aCursorPosition, anImage, aDisplayString,
				aContextInformation, null);
		context = aContext;
	}

	@Override
	public void setAdditionalProposalInfo(final Object anAdditionalProposalInfo) {
		Object tempAdditionalProposalInfo = anAdditionalProposalInfo;

		if (anAdditionalProposalInfo instanceof EObject && ((EObject) anAdditionalProposalInfo).eIsProxy()
				&& requiresResolvingForContentAssist((EObject) anAdditionalProposalInfo)) {

			// resolve the proxy before continuing
			tempAdditionalProposalInfo = new Provider<EObject>() {

				@Override
				public EObject get() {
					return EcoreUtil.resolve((EObject) anAdditionalProposalInfo, context.getResource());
				}
			}.get();
		}

		if (tempAdditionalProposalInfo instanceof VariableOrConstantEntity
				&& ((VariableOrConstantEntity) tempAdditionalProposalInfo).eContainer() instanceof SuiteDefinition) {
			suiteDefiningProposedParameter = (SuiteDefinition) ((VariableOrConstantEntity) tempAdditionalProposalInfo)
					.eContainer();

			// suite parameter proposals are NEVER scoped, even though XText might think so...
			String[] tempReplacementStringParts = getReplacementString().split("\\.");
			setReplacementString(tempReplacementStringParts[tempReplacementStringParts.length - 1]);
		}

		super.setAdditionalProposalInfo(tempAdditionalProposalInfo);
	}

	private boolean requiresResolvingForContentAssist(EObject anObject) {
		return (anObject instanceof TestDefinition || anObject instanceof CallDefinition);
	}

	public SuiteDefinition getSuiteDefiningProposedParameter() {
		return suiteDefiningProposedParameter;
	}

	@Override
	public IInformationControlCreator getInformationControlCreator() {
		if (useHtmlAdditionalProposalInfo) {
			return new IInformationControlCreator() {

				@Override
				public IInformationControl createInformationControl(Shell aParent) {
					if (BrowserInformationControl.isAvailable(aParent)) {
						return new BrowserInformationControl(aParent, JFaceResources.DIALOG_FONT, true);
					} else {
						return new DefaultInformationControl(aParent);
					}
				}
			};
		} else {
			// just use the default
			return super.getInformationControlCreator();
		}
	}
}
