package abergavenny.minimal.core.preferences;

import java.util.Locale;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

public class PreferenceUtils {

	private static final String NODE_ID = "abergavenny.minimal.core";

	private static final boolean DEFAULT_SHOW_INITIALIZER = false;
	private static final String DEFAULT_GUI_LANGUAGE = Locale.GERMAN.getLanguage();

	public static final String SHOW_INITIALIZER = "preferences.showInitializer";
	public static final String GUI_LANGUAGE = "preferences.language";

	public static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(NODE_ID);
	}

	public static String getLanguage() {
		return getPreferences().get(GUI_LANGUAGE, DEFAULT_GUI_LANGUAGE);
	}

	public static void setLanguage(String value) {
		getPreferences().put(GUI_LANGUAGE, value);
		flush();
	}

	public static boolean getShowInitializer() {
		return getPreferences().getBoolean(SHOW_INITIALIZER, DEFAULT_SHOW_INITIALIZER);
	}

	public static void setShowInitializer(boolean value) {
		getPreferences().putBoolean(SHOW_INITIALIZER, value);
		flush();
	}

	private static void flush() {
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
