package abergavenny.minimal.core.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

import abergavenny.minimal.core.Activator;
import abergavenny.minimal.core.preferences.PreferenceUtils;

public class SetLocaleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println(Activator.PLUGIN_ID + " SetLocaleHandler" + event.getParameters());

		String language = event.getParameter(PreferenceUtils.GUI_LANGUAGE);

		if (language != null) {
			PreferenceUtils.setLanguage(language);
			PlatformUI.getWorkbench().restart();
		}

		return null;
	}
}
