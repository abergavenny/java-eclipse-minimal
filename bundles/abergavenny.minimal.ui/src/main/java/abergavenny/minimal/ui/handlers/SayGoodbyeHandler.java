package abergavenny.minimal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class SayGoodbyeHandler extends AbstractHandler {
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        System.out.println("Goodbye from your custom menu action! (plugin.xml)");
        return null;
    }
}
