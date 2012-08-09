/**
 * 
 */
package de.gebit.integrity.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.gebit.integrity.ui.internal.DSLActivator;

/**
 * Initializes our preferences with their default values.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * The autoformat preference.
	 */
	public static final String FORMAT_ON_SAVE_PREFERENCE = "formatOnSave";

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore tempPreferenceStore = DSLActivator.getInstance().getPreferenceStore();

		tempPreferenceStore.setDefault(FORMAT_ON_SAVE_PREFERENCE, true);
	}

}
