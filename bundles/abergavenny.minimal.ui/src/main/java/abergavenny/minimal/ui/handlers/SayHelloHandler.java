package abergavenny.minimal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import abergavenny.minimal.ui.Messages;

public class SayHelloHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println(Messages.hello + " from your custom menu action! (plugin.xml)");
		return null;
	}
}