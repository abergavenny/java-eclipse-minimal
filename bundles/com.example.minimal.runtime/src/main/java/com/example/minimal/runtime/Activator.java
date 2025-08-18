package com.example.minimal.runtime;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "com.example.minimal.runtime";
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(PLUGIN_ID + " Plugin started.");
		Activator.context = bundleContext;

		logOsgiBootConfigLocation();

		// Eclipse Preference API should be used
		// https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.platform.doc.user%2Freference%2Fref-72.htm
		String instancePreferenceLanguage = ApplicationPreferences.getLanguage();

		System.out.println(PLUGIN_ID + " Preferences: " + instancePreferenceLanguage);

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println(PLUGIN_ID + " Plugin stopped.");
	}

	private void logOsgiBootConfigLocation() {
		// Usually this should only be used for boot configuration
		// Should not be changed during runtime
		// https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fmisc%2Fruntime-options.html
		String configArea = System.getProperty("osgi.configuration.area");

		if (configArea == null) {
			System.err.println("Cannot read config.ini: osgi.configuration.area is undefined");
			return;
		}
	}
}
