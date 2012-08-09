/**
 * 
 */
package de.gebit.integrity.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.xtext.ui.editor.XtextEditor;

import de.gebit.integrity.ui.internal.DSLActivator;
import de.gebit.integrity.ui.preferences.IntegrityPreferenceInitializer;

/**
 * The editor for the Integrity documents.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityEditor extends XtextEditor {

	@Override
	protected void performSave(boolean anOverwrite, IProgressMonitor aProgressMonitor) {
		boolean tempAutoFormat = DSLActivator.getInstance().getPreferenceStore()
				.getBoolean(IntegrityPreferenceInitializer.FORMAT_ON_SAVE_PREFERENCE);

		if (tempAutoFormat) {
			((SourceViewer) getInternalSourceViewer()).doOperation(ISourceViewer.FORMAT);
		}

		super.performSave(anOverwrite, aProgressMonitor);
	}

}
