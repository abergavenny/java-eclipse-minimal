package abergavenny.minimal.ui;

import java.util.Locale;

import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import abergavenny.minimal.core.preferences.PreferenceUtils;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "abergavenny.minimal.ui"; //$NON-NLS-1$
	public static final String NLS_ID = "abergavenny.minimal.ui.messages"; //$NON-NLS-1$

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(PLUGIN_ID + " Plugin started.");
		Activator.context = bundleContext;

		// Load NLS
		System.out.println(PLUGIN_ID + " Initialize NLS for locale: " + PreferenceUtils.getLanguage() + " fallback: "
				+ Locale.getDefault().getLanguage());
		NLS.initializeMessages(NLS_ID, Messages.class);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println(PLUGIN_ID + " Plugin stopped.");
	}
}
