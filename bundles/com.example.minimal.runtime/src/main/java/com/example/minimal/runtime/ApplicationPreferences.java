package com.example.minimal.runtime;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

public class ApplicationPreferences {
	private static final String NODE_ID = Activator.PLUGIN_ID;
	private static final IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(NODE_ID);

	public static String getLanguage() {
		return prefs.get("language", "en_GB");
	}

	public static void setLanguage(String value) {
		prefs.put("language", value);

		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
}
