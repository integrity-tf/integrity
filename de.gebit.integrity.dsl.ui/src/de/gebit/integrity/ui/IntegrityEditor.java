/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;

import de.gebit.integrity.ui.internal.DSLActivator;
import de.gebit.integrity.ui.preferences.IntegrityPreferenceInitializer;
import de.gebit.integrity.validation.DSLJavaValidator;

/**
 * The editor for the Integrity documents.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityEditor extends XtextEditor {

	protected static final String INTEGRITY_KEYBINDING_SCOPE = "de.gebit.integrity.ui.IntegrityEditor";

	public IntegrityEditor() {
		super();
		setKeyBindingScope(INTEGRITY_KEYBINDING_SCOPE);
	}

	@Override
	protected void performSave(boolean anOverwrite, IProgressMonitor aProgressMonitor) {
		if (DSLActivator.getInstance().getPreferenceStore()
				.getBoolean(IntegrityPreferenceInitializer.FORMAT_ON_SAVE_PREFERENCE)) {
			((SourceViewer) getInternalSourceViewer()).doOperation(ISourceViewer.FORMAT);
		}

		if (DSLActivator.getInstance().getPreferenceStore()
				.getBoolean(IntegrityPreferenceInitializer.ORGANIZE_IMPORTS_ON_SAVE_PREFERENCE)) {
			IntegrityEditor.this.organizeImports();
		}

		super.performSave(anOverwrite, aProgressMonitor);
	}

	@Override
	protected void createActions() {
		super.createActions();

		Action tempAction = new TextEditorAction(XtextUIMessages.getResourceBundle(), "OrganizeImports.", this) {

			@Override
			public void run() {
				IntegrityEditor.this.organizeImports();
			}

		};
		tempAction.setActionDefinitionId("de.gebit.integrity.dsl.ui.OrganizeImportsAction");
		setAction("OrganizeImports", tempAction);
		markAsStateDependentAction("OrganizeImports", true);
	}

	/**
	 * Sorts all the import statements in the given document and eliminates duplicates.
	 * 
	 * @param aDoc
	 *            the doc to work on
	 */
	public void organizeImports() {
		IXtextDocument tempDoc = getDocument();

		try {
			List<String[]> tempImports = new ArrayList<String[]>();
			int tempLineNumber = 0;
			int tempImportBlockFirstLineNumber = -1;
			int tempImportBlockLastLineNumber = -1;
			while (tempLineNumber < tempDoc.getNumberOfLines()) {
				IRegion tempLineRegion = tempDoc.getLineInformation(tempLineNumber);
				String tempLine = tempDoc.get(tempLineRegion.getOffset(), tempLineRegion.getLength()).trim();

				if (tempLine.startsWith("import ")) {
					if (tempImportBlockFirstLineNumber == -1) {
						tempImportBlockFirstLineNumber = tempLineNumber;
					}
					tempImportBlockLastLineNumber = tempLineNumber;

					tempImports.add(tempLine.substring(7).split("\\."));
					tempLineNumber++;
					continue;
				} else if (tempLine.length() == 0) {
					tempLineNumber++;
					continue;
				} else {
					if (tempImportBlockFirstLineNumber >= 0) {
						// Any content except import statements will end the import block
						break;
					} else {
						// Not yet encountered an import block -> go on
						tempLineNumber++;
						continue;
					}
				}
			}

			if (tempImports.size() == 0 || tempImportBlockLastLineNumber - tempImportBlockFirstLineNumber < 0) {
				// no imports to sort
				return;
			}

			Collections.sort(tempImports, new Comparator<String[]>() {

				@Override
				public int compare(String[] aFirst, String[] aSecond) {
					for (int i = 0; i < Math.min(aFirst.length, aSecond.length); i++) {
						int tempCompare = aFirst[i].compareTo(aSecond[i]);
						if (tempCompare != 0) {
							return tempCompare;
						}
					}

					return aFirst.length - aSecond.length;
				}
			});

			// Remove duplicate imports
			Iterator<String[]> tempIter = tempImports.iterator();
			String[] tempPreviousImport = null;
			while (tempIter.hasNext()) {
				String[] tempImport = tempIter.next();
				if (tempPreviousImport != null && Arrays.equals(tempPreviousImport, tempImport)) {
					tempIter.remove();
				} else {
					tempPreviousImport = tempImport;
				}
			}

			// Reinsert the imports into the document
			for (int i = 0; i <= tempImportBlockLastLineNumber - tempImportBlockFirstLineNumber; i++) {
				IRegion tempLine = tempDoc.getLineInformation(i + tempImportBlockFirstLineNumber);
				if (i < tempImports.size()) {
					String tempNewLine
							= "import " + Arrays.asList(tempImports.get(i)).stream().collect(Collectors.joining("."));
					if (!tempNewLine.equals(tempDoc.get(tempLine.getOffset(), tempLine.getLength()))) {
						tempDoc.replace(tempLine.getOffset(), tempLine.getLength(), tempNewLine);
					}
				} else {
					// Remove superfluous lines.
					String tempDelimiter = tempDoc.getLineDelimiter(i + tempImportBlockFirstLineNumber);
					tempDoc.replace(tempLine.getOffset(), tempLine.getLength() + tempDelimiter.length(), "");

					// This changes the length of the import block and our position
					i--;
					tempImportBlockLastLineNumber--;
				}
			}

			// Finally eliminate unused imports
			Diagnostic tempDiagnosticRoot = tempDoc.readOnly(new IUnitOfWork<Diagnostic, XtextResource>() {

				@Override
				public Diagnostic exec(XtextResource aState) throws Exception {
					return Diagnostician.INSTANCE.validate(aState.getParseResult().getRootASTElement());
				}

			});

			List<Diagnostic> tempDiagnostics = new ArrayList<>();
			if (tempDiagnosticRoot.getChildren() != null && tempDiagnosticRoot.getChildren().size() > 0) {
				tempDiagnostics.addAll(tempDiagnosticRoot.getChildren());
			} else {
				tempDiagnostics.add(tempDiagnosticRoot);
			}

			for (int i = tempDiagnostics.size() - 1; i >= 0; i--) {
				Diagnostic tempCandidate = tempDiagnostics.get(i);
				if ((tempCandidate instanceof AbstractValidationDiagnostic) && DSLJavaValidator.UNUSED_IMPORT
						.equals(((AbstractValidationDiagnostic) tempCandidate).getIssueCode())) {
					List<?> tempData = tempCandidate.getData();
					String[] tempStringData = (String[]) tempData.get(tempData.size() - 1);
					int tempOffset = Integer.parseInt(tempStringData[0]);
					int tempLength = Integer.parseInt(tempStringData[1]);

					tempDoc.replace(tempOffset, tempLength, "");
					int tempLine = tempDoc.getLineOfOffset(tempOffset);
					if (tempDoc.getLineInformation(tempLine).getLength() == 0) {
						tempDoc.replace(tempOffset, tempDoc.getLineDelimiter(tempLine).length(), "");
					}
				}
			}
		} catch (BadLocationException exc) {
			throw new RuntimeException(exc);
		}
	}

}
