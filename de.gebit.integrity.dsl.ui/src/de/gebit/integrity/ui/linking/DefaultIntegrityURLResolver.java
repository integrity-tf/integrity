/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.linking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;

import com.google.inject.Inject;

import de.gebit.integrity.ui.search.IntegritySearch;

/**
 * The default implementation of an {@link IntegrityURLResolver}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultIntegrityURLResolver implements IntegrityURLResolver {

	/**
	 * The {@link IntegritySearch} engine.
	 */
	@Inject
	protected IntegritySearch integritySearch;

	/**
	 * The pattern to match URLs.
	 */
	private static final Pattern INTEGRITY_URL_PATTERN = Pattern.compile("integrity:\\/\\/([^#]+?)\\/?(?:\\#(\\d+))?");

	@Override
	public boolean parseURL(String anURL) {
		Matcher tempMatcher = INTEGRITY_URL_PATTERN.matcher(anURL);
		if (tempMatcher.matches()) {
			String tempSuiteName = tempMatcher.group(1);
			boolean tempHasLineNumber = tempMatcher.groupCount() > 1 && tempMatcher.group(2) != null;
			IEditorPart tempEditor = integritySearch.openSuiteDefinitionByName(tempSuiteName, !tempHasLineNumber);
			if (tempEditor == null) {
				showError("Could not find a suite named '" + tempSuiteName + "' in your workspace.");
			} else {
				if (tempHasLineNumber) {
					int tempLineNumber = Integer.parseInt(tempMatcher.group(2));
					if (!jumpToLine(tempEditor, tempLineNumber)) {
						showError("Could not find line number " + tempLineNumber + " in suite '" + tempSuiteName + "'");
					}
				}
			}

			return true;
		}
		return false;
	}

	private void showError(final String aMessage) {
		Runnable tempRunnable = new Runnable() {
			@Override
			public void run() {
				MessageDialog.openError(null, "Integrity Editor", aMessage);
			}
		};

		Display.getDefault().asyncExec(tempRunnable);
	}

	private boolean jumpToLine(IEditorPart anEditor, int aLineNumber) {
		if (!(anEditor instanceof ITextEditor) || aLineNumber <= 0) {
			return false;
		}
		final ITextEditor tempEditor = (ITextEditor) anEditor;
		IDocument tempDocument = tempEditor.getDocumentProvider().getDocument(tempEditor.getEditorInput());
		if (tempDocument != null) {
			try {
				final IRegion tempLineInfo = tempDocument.getLineInformation(aLineNumber - 1);

				if (tempLineInfo != null) {
					// This is performed asynchronously because Xtext does it in the same way since 2.8 or so.
					// The Xtext change originally caused issue #110: Jumping to test/call/suite invocations via
					// integrity:// URLs jumps to suitedef instead
					Job selectAndRevealJob = new Job("Select and reveal line " + aLineNumber) {
						@Override
						protected IStatus run(IProgressMonitor monitor) {
							tempEditor.getSite().getWorkbenchWindow().getWorkbench().getDisplay()
									.asyncExec(new Runnable() {
										@Override
										public void run() {
											tempEditor.selectAndReveal(tempLineInfo.getOffset(),
													tempLineInfo.getLength());

										}
									});
							return Status.OK_STATUS;
						}
					};
					selectAndRevealJob.setSystem(true);
					selectAndRevealJob.setPriority(Job.SHORT);
					selectAndRevealJob.schedule();

					return true;
				} else {
					return false;
				}
			} catch (BadLocationException exc) {
				return false;
			}
		}

		return false;
	}

}
