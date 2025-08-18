package com.example.minimal.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction quitAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		quitAction = ActionFactory.QUIT.create(window);
		register(quitAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		menuBar.updateAll(true);

		MenuManager quitMenu = new MenuManager("Quit", null);
		quitMenu.add(quitAction);

		menuBar.add(quitMenu);
	}
}