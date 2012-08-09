/**
 * 
 */
package de.gebit.integrity.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

import de.gebit.integrity.ui.internal.DSLActivator;

/**
 * The root preference page.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityRootPreferencePage extends LanguageRootPreferencePage {

	@Override
	public void init(IWorkbench aWorkbench) {
		// Use the UI preference store here (right now there aren't any non-UI DSL-specific settings to configure here)
		setPreferenceStore(DSLActivator.getInstance().getPreferenceStore());
		super.init(aWorkbench);
	}

	@Override
	protected void createFieldEditors() {
		super.createFieldEditors();
		BooleanFieldEditor tempBooleanFieldEditor = new BooleanFieldEditor(
				IntegrityPreferenceInitializer.FORMAT_ON_SAVE_PREFERENCE, "Auto-format documents before saving",
				getFieldEditorParent());
		tempBooleanFieldEditor.setPreferenceStore(doGetPreferenceStore());
		addField(tempBooleanFieldEditor);
	}

}
