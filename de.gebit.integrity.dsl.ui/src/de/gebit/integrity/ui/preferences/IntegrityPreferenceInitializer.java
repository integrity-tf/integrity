/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.gebit.integrity.ui.internal.DSLActivator;

/**
 * Initializes our preferences with their default values.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * The autoformat preference.
	 */
	public static final String FORMAT_ON_SAVE_PREFERENCE = "formatOnSave";

	/**
	 * The organize imports on save preference.
	 */
	public static final String ORGANIZE_IMPORTS_ON_SAVE_PREFERENCE = "organizeImportsOnSave";

	/**
	 * Warn of unused imports.
	 */
	public static final String UNUSED_IMPORTS_WARNING = "unusedImportsWarning";

	/**
	 * The shorten references preference.
	 */
	public static final String SHORTEN_REFERENCES_DEPTH_PREFERENCE = "shortenReferenceDepth";

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore tempPreferenceStore = DSLActivator.getInstance().getPreferenceStore();

		tempPreferenceStore.setDefault(FORMAT_ON_SAVE_PREFERENCE, true);
		tempPreferenceStore.setDefault(UNUSED_IMPORTS_WARNING, true);
		tempPreferenceStore.setDefault(ORGANIZE_IMPORTS_ON_SAVE_PREFERENCE, true);
		tempPreferenceStore.setDefault(SHORTEN_REFERENCES_DEPTH_PREFERENCE, 100);
	}

}
