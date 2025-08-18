package abergavenny.minimal.ui.actions;

import org.eclipse.jface.action.Action;

public class SayHelloAction extends Action {
	public SayHelloAction() {
		super("Say Hello JAVA");
		setId("abergavenny.minimal.ui.actions.sayHello");
	}
	
	@Override
	public void run() {
		System.out.println("Hello from your custom menu action! (programmatically)");
	}
}
