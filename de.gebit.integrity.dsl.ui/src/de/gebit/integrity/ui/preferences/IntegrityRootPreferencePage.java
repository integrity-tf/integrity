/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

import com.google.inject.Inject;

import de.gebit.integrity.ui.internal.DSLActivator;
import de.gebit.integrity.validation.DSLJavaValidator;

/**
 * The root preference page.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityRootPreferencePage extends LanguageRootPreferencePage {

	/**
	 * The validator to be configured.
	 */
	@Inject
	private DSLJavaValidator validator;

	@Override
	public void init(IWorkbench aWorkbench) {
		// Use the UI preference store here (right now there aren't any non-UI DSL-specific settings to configure here)
		setPreferenceStore(DSLActivator.getInstance().getPreferenceStore());
		super.init(aWorkbench);
	}

	@Override
	protected void createFieldEditors() {
		super.createFieldEditors();

		BooleanFieldEditor tempFormatOnSaveField
				= new BooleanFieldEditor(IntegrityPreferenceInitializer.FORMAT_ON_SAVE_PREFERENCE,
						"Auto-format documents before saving", getFieldEditorParent());
		tempFormatOnSaveField.setPreferenceStore(doGetPreferenceStore());
		addField(tempFormatOnSaveField);

		BooleanFieldEditor tempOrganizeImportsOnSave
				= new BooleanFieldEditor(IntegrityPreferenceInitializer.ORGANIZE_IMPORTS_ON_SAVE_PREFERENCE,
						"Auto-organize imports before saving", getFieldEditorParent());
		tempOrganizeImportsOnSave.setPreferenceStore(doGetPreferenceStore());
		addField(tempOrganizeImportsOnSave);

		BooleanFieldEditor tempWarnUnusedImports
				= new BooleanFieldEditor(IntegrityPreferenceInitializer.UNUSED_IMPORTS_WARNING,
						"Warn about unused imports", getFieldEditorParent());
		tempWarnUnusedImports.setPreferenceStore(doGetPreferenceStore());
		addField(tempWarnUnusedImports);

		IntegerFieldEditor tempShortenReferencesEditor
				= new IntegerFieldEditor(IntegrityPreferenceInitializer.SHORTEN_REFERENCES_DEPTH_PREFERENCE,
						"Target package depth for references", getFieldEditorParent());
		tempShortenReferencesEditor.setPreferenceStore(doGetPreferenceStore());
		addField(tempShortenReferencesEditor);
	}

	@Override
	protected void performApply() {
		super.performApply();

		validator.setReferenceLengthTarget(DSLActivator.getInstance().getPreferenceStore()
				.getInt(IntegrityPreferenceInitializer.SHORTEN_REFERENCES_DEPTH_PREFERENCE));
		validator.setWarnUnusedImports(DSLActivator.getInstance().getPreferenceStore()
				.getBoolean(IntegrityPreferenceInitializer.UNUSED_IMPORTS_WARNING));
	}

	@Override
	public boolean performOk() {
		boolean tempOk = super.performOk();

		validator.setReferenceLengthTarget(DSLActivator.getInstance().getPreferenceStore()
				.getInt(IntegrityPreferenceInitializer.SHORTEN_REFERENCES_DEPTH_PREFERENCE));
		validator.setWarnUnusedImports(DSLActivator.getInstance().getPreferenceStore()
				.getBoolean(IntegrityPreferenceInitializer.UNUSED_IMPORTS_WARNING));

		return tempOk;
	}

}
