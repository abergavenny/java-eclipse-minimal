package abergavenny.minimal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import abergavenny.minimal.core.Activator;
import abergavenny.minimal.core.preferences.PreferenceUtils;

public class ToggleInitializerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println(Activator.PLUGIN_ID + " SetLocaleHandler" + event.getParameters());
		
		PreferenceUtils.setShowInitializer(!PreferenceUtils.getShowInitializer());

		return null;
	}

}
