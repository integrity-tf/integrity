/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

import de.gebit.integrity.ui.internal.DSLActivator;

/**
 * The root preference page.
 * 
 * @author Rene Schneider - initial API and implementation
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
