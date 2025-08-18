package abergavenny.minimal.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		System.out.println("PreferencesInitializer.initializeDefaultPreferences()");
	}
}
