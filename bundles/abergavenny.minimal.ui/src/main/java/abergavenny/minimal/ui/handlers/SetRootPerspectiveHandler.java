package abergavenny.minimal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class SetRootPerspectiveHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// resetPerspective();
		// setPerspective();

		return null;
	}

	private void resetPerspective() {
		System.out.println("reset!");
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.resetPerspective();
	}

	private void setPerspective() {
		IPerspectiveDescriptor descriptor = PlatformUI.getWorkbench().getPerspectiveRegistry()
				.findPerspectiveWithId("abergavenny.minimal.ui.rootperspective");

		System.out.println("Id: " + descriptor.getId());
		System.out.println("Label: " + descriptor.getLabel());
		System.out.println("Default: " + descriptor.getDefaultShowIn());

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setPerspective(descriptor);
	}

}
