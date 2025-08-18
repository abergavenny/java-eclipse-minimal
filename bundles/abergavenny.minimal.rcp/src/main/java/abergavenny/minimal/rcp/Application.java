package abergavenny.minimal.rcp;

import java.util.Locale;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import abergavenny.minimal.core.preferences.PreferenceUtils;
import abergavenny.minimal.ui.dialogs.InitializationDialog;

public class Application implements IApplication {

	public Application() {
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Application started.");

		// forceBundleStart("abergavenny.minimal.core");

		loadPreferences();

		Display display = PlatformUI.createDisplay();

		try {
			if (PreferenceUtils.getShowInitializer()) {
				showSelection(display);
			}

			System.out.println("Launching GUI ... ");
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			return returnCode == PlatformUI.RETURN_RESTART ? IApplication.EXIT_RESTART : IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}

	@Override
	public void stop() {
		System.out.println("Application stopped.");
	}

	private void forceBundleStart(String pluginId) {
		System.out.println("Request bundle start: " + pluginId);

		Bundle bundle = Platform.getBundle(pluginId);
		if (bundle != null && bundle.getState() != Bundle.ACTIVE) {
			try {
				bundle.start();
			} catch (BundleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void loadPreferences() {

		String language = PreferenceUtils.getLanguage();

		Locale locale;
		switch (language) {
		case "de":
			locale = Locale.GERMAN;
			break;
		case "en":
			locale = Locale.ENGLISH;
			break;
		default:
			locale = Locale.GERMAN;
		}

		Locale.setDefault(locale);

		System.out.println("Loaded locale: " + Locale.getDefault());

		reloadNLSMessages();
	}

	private void reloadNLSMessages() {
		NLS.initializeMessages("abergavenny.minimal.ui.messages", abergavenny.minimal.ui.Messages.class);
	}

	private boolean showSelection(Display display) {
		Shell shell = new Shell(display);
		InitializationDialog dialog = new InitializationDialog(shell);
		return dialog.open() == Window.OK;
	}
}