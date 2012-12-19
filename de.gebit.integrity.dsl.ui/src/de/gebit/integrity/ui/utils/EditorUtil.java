/**
 * 
 */
package de.gebit.integrity.ui.utils;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public final class EditorUtil {

	private EditorUtil() {
		// private constructor
	}

	public static final boolean jumpToLine(IEditorPart anEditor, int aLineNumber) {
		if (!(anEditor instanceof ITextEditor) || aLineNumber <= 0) {
			return false;
		}
		ITextEditor tempEditor = (ITextEditor) anEditor;
		IDocument tempDocument = tempEditor.getDocumentProvider().getDocument(tempEditor.getEditorInput());
		if (tempDocument != null) {
			IRegion tempLineInfo = null;
			try {
				tempLineInfo = tempDocument.getLineInformation(aLineNumber - 1);
			} catch (BadLocationException exc) {
				// ignored
			}
			if (tempLineInfo != null) {
				tempEditor.selectAndReveal(tempLineInfo.getOffset(), tempLineInfo.getLength());
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
