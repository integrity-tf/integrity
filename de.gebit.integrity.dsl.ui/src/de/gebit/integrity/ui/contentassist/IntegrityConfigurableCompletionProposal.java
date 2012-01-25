/**
 * 
 */
package de.gebit.integrity.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

import com.google.inject.Provider;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.TestDefinition;

/**
 * A context-aware configurable completion proposal. This proposal knows its content assist context and uses this in
 * order to resolve the EObject proxy if necessary on request of additional proposal info, but only if the fully
 * resolved object is necessary to display certain content assist info later (via
 * {@link de.gebit.integrity.ui.documentation.IntegrityEObjectDocumentationProvider}).
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityConfigurableCompletionProposal extends ConfigurableCompletionProposal {

	/**
	 * The context.
	 */
	private ContentAssistContext context;

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
			IContextInformation aContextInformation, String anAdditionalProposalInfo, ContentAssistContext aContext) {
		super(aReplacementString, aReplacementOffset, aReplacementLength, aCursorPosition, anImage, aDisplayString,
				aContextInformation, anAdditionalProposalInfo);
		context = aContext;
	}

	@Override
	public void setAdditionalProposalInfo(Object anAdditionalProposalInfo) {
		if (anAdditionalProposalInfo instanceof EObject && ((EObject) anAdditionalProposalInfo).eIsProxy()
				&& requiresResolvingForContentAssist((EObject) anAdditionalProposalInfo)) {

			// set up provider to resolve object when necessary (-> called by documentation provider)
			final EObject tempObject = (EObject) anAdditionalProposalInfo;
			super.setAdditionalProposalInfo(new Provider<EObject>() {

				@Override
				public EObject get() {
					return EcoreUtil.resolve(tempObject, context.getResource());
				}
			});
		} else {
			// no resolving necessary
			super.setAdditionalProposalInfo(anAdditionalProposalInfo);
		}
	}

	private boolean requiresResolvingForContentAssist(EObject anObject) {
		return (anObject instanceof TestDefinition || anObject instanceof CallDefinition);
	}

}
