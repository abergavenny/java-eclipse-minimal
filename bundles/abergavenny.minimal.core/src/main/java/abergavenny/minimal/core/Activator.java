package abergavenny.minimal.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin implements IPreferenceChangeListener {

	public static final String PLUGIN_ID = "abergavenny.minimal.core"; //$NON-NLS-1$

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(PLUGIN_ID + " Plugin started.");
		Activator.context = bundleContext;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println(PLUGIN_ID + " Plugin stopped.");
	}

	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		System.out.println(PLUGIN_ID + " Activator.preferenceChange() " + event.getKey());
	}

}
