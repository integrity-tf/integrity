/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.utils.IntegrityDSLUtil;

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

	/**
	 * The additional proposal info object. Stored here because the superclass one is private.
	 */
	private Object additionalProposalInfoObject;

	/**
	 * The resolved {@link #additionalProposalInfoObject} is cached here.
	 */
	private EObject resolvedAdditionalProposalInfoObject;

	/**
	 * The context resource. Stored here because the superclass one is private.
	 */
	private Resource proposalContextResource;

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

		additionalProposalInfoObject = tempAdditionalProposalInfo;
		super.setAdditionalProposalInfo(tempAdditionalProposalInfo);
	}

	@Override
	public void setProposalContextResource(Resource aContextResource) {
		proposalContextResource = aContextResource;
		super.setProposalContextResource(aContextResource);
	}

	/**
	 * Returns the additional proposal info object, if possible. This only returns the plain object (but attempts to
	 * resolve it, if necessary).
	 * 
	 * @return the object or null
	 */
	public EObject getAdditionalProposalInfoObject() {
		if (resolvedAdditionalProposalInfoObject == null) {
			EObject tempResult = null;
			if (additionalProposalInfoObject instanceof EObject) {
				tempResult = (EObject) additionalProposalInfoObject;
			} else {
				if (additionalProposalInfoObject instanceof Provider) {
					Object tempObject = ((Provider<?>) additionalProposalInfoObject).get();
					if (tempObject instanceof EObject) {
						tempResult = (EObject) tempObject;
					}
				}
			}
			if (tempResult != null && tempResult.eIsProxy()) {
				tempResult = EcoreUtil.resolve(tempResult, proposalContextResource);
			}

			resolvedAdditionalProposalInfoObject = tempResult;
		}

		return resolvedAdditionalProposalInfoObject;
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

	/**
	 * Checks whether the proposed element is in the "local" suite.
	 * 
	 * @return
	 */
	public boolean isReferencingObjectInLocalSuite() {
		if (getAdditionalProposalInfoObject() != null) {
			SuiteDefinition tempContainingSuite = IntegrityDSLUtil.findUpstreamContainer(SuiteDefinition.class,
					(EObject) getAdditionalProposalInfoObject());
			if (tempContainingSuite != null) {
				SuiteDefinition tempCurrentSuite = IntegrityDSLUtil.findUpstreamContainer(SuiteDefinition.class,
						context.getCurrentModel());
				return tempCurrentSuite == tempContainingSuite;
			}
		}

		return false;
	}

	/**
	 * Checks whether the proposed element is in the "local" package.
	 * 
	 * @return
	 */
	public boolean isReferencingObjectInLocalPackage() {
		if (getAdditionalProposalInfoObject() != null) {
			PackageDefinition tempContainingPackage = IntegrityDSLUtil.findUpstreamContainer(PackageDefinition.class,
					(EObject) getAdditionalProposalInfoObject());
			if (tempContainingPackage != null) {
				PackageDefinition tempCurrentPackage = IntegrityDSLUtil.findUpstreamContainer(PackageDefinition.class,
						context.getCurrentModel());
				return tempCurrentPackage == tempContainingPackage;
			}
		}

		return false;
	}
}
