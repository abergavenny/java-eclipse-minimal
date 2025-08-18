package com.example.minimal.runtime;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.example.minimal.ui.ApplicationWorkbenchAdvisor;

public class Application implements IApplication {

	public Application() {
		logPreferences();
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
			System.out.println("Launching GUI ...");
			int code = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			return code == PlatformUI.RETURN_RESTART ? IApplication.EXIT_RESTART : IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}

	@Override
	public void stop() {
		System.out.println("Headless application stopped.");
	}

	private void logPreferences() {
		System.out.println("Language: " + ApplicationPreferences.getLanguage());
		ApplicationPreferences.setLanguage("de_DE");
		System.out.println("Language: " + ApplicationPreferences.getLanguage());
	}
}