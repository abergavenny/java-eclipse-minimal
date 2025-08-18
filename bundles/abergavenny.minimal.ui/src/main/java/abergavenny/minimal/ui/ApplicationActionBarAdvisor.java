package abergavenny.minimal.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import abergavenny.minimal.ui.actions.SayHelloAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IAction quitApplicationAction;
	private IAction sayHelloAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		// It is recommended to use the command framework instead
		// by using handler classes and then wire commands to the menu contribution

		// Action-based menu contributions
		quitApplicationAction = ActionFactory.QUIT.create(window);
		register(quitApplicationAction);

		sayHelloAction = new SayHelloAction();
		register(sayHelloAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		// & mnemonic (keyboard shortcut)
		MenuManager mainMenu = new MenuManager("&Main JAVA", "abergavenny.minimal.ui.menu.mainMenu");
		mainMenu.add(quitApplicationAction);

		MenuManager topLevelMenu = new MenuManager("Top-Level JAVA", "abergavenny.minimal.ui.menu.topLevelMenu");
		topLevelMenu.add(sayHelloAction);

		menuBar.add(mainMenu);
		menuBar.add(topLevelMenu);
	}
}
