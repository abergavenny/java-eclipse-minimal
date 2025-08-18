package com.example.minimal.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.example.minimal.ui";

	private static Activator plugin;

	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println(PLUGIN_ID + " Plugin started.");
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		System.out.println(PLUGIN_ID + " Plugin stopped.");
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

}
