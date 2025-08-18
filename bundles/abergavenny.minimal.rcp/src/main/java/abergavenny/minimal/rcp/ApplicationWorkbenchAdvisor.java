package abergavenny.minimal.rcp;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import abergavenny.minimal.ui.RootPerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		configurer.setSaveAndRestore(false);
	}

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		// Note: Will get called twice internally, second run ensures the correct layout
		// is applied; no side effects should be performed

		return RootPerspective.ID;
	}

	@Override
	public void preStartup() {
		// TODO Auto-generated method stub
		super.preStartup();

		System.out.println(Activator.PLUGIN_ID + " ApplicationWorkbenchAdvisor.preStartup()");
	}
}
