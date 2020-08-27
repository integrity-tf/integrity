/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.quickfix;

import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import de.gebit.integrity.ui.internal.DSLActivator;
import de.gebit.integrity.ui.preferences.IntegrityPreferenceInitializer;
import de.gebit.integrity.validation.DSLJavaValidator;

/**
 * The quickfix provider.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLQuickfixProvider extends DefaultQuickfixProvider {

	/**
	 * Allows for quick shortening of references.
	 * 
	 * @param anIssue
	 *            the issue
	 * @param anAcceptor
	 *            the acceptor
	 */
	@Fix(DSLJavaValidator.SHORTENABLE_REFERENCE)
	public void fixShortenableReference(Issue anIssue, IssueResolutionAcceptor anAcceptor) {
		int tempTargetDepth = DSLActivator.getInstance().getPreferenceStore()
				.getInt(IntegrityPreferenceInitializer.SHORTEN_REFERENCES_DEPTH_PREFERENCE);

		// See corresponding validation rule for details on this encoding
		String[] tempFullyQualifiedName = new String[anIssue.getData().length - 1];
		System.arraycopy(anIssue.getData(), 1, tempFullyQualifiedName, 0, tempFullyQualifiedName.length);
		int tempLastImportOffset = Integer.parseInt(anIssue.getData()[0]);

		StringBuilder tempImport = new StringBuilder();
		StringBuilder tempReference = new StringBuilder();
		for (int k = 0; k < tempFullyQualifiedName.length - tempTargetDepth - 1; k++) {
			tempImport.append(tempFullyQualifiedName[k] + ".");
		}
		tempImport.append("*");
		for (int k = tempFullyQualifiedName.length - tempTargetDepth - 1; k < tempFullyQualifiedName.length; k++) {
			if (tempReference.length() > 0) {
				tempReference.append(".");
			}
			tempReference.append(tempFullyQualifiedName[k]);
		}

		if (tempReference.length() != anIssue.getLength()) {
			anAcceptor.accept(anIssue, "Shorten reference to '" + tempReference + "'",
					"Shorten reference to '" + tempReference + "' and import '" + tempImport + "'", null,
					(IModificationContext context) -> {
						IXtextDocument tempDocument = context.getXtextDocument();

						tempDocument.replace(anIssue.getOffset(), anIssue.getLength(), tempReference.toString());
						String tempImportStatement = "import " + tempImport.toString();

						if (new FindReplaceDocumentAdapter(tempDocument).find(0, tempImportStatement, true, true, false,
								false) == null) {
							int tempImportOffset = (tempLastImportOffset > 0)
									? tempLastImportOffset + tempDocument.getLineDelimiter(0).length()
									: 0;
							tempDocument.replace(tempImportOffset, 0,
									tempImportStatement + tempDocument.getLineDelimiter(0));
						}
					});
		}

	}

	@Fix(DSLJavaValidator.UNUSED_IMPORT)
	public void fixUnusedImport(Issue anIssue, IssueResolutionAcceptor anAcceptor) {
		anAcceptor.accept(anIssue, "Remove this unused import", "Remove this unused import", null,
				(IModificationContext context) -> {
					IXtextDocument tempDocument = context.getXtextDocument();

					tempDocument.replace(anIssue.getOffset(), anIssue.getLength(), "");
					int tempLine = tempDocument.getLineOfOffset(anIssue.getOffset());
					if (tempDocument.getLineInformation(tempLine).getLength() == 0) {
						tempDocument.replace(anIssue.getOffset(), tempDocument.getLineDelimiter(tempLine).length(), "");
					}
				});
	}

}
