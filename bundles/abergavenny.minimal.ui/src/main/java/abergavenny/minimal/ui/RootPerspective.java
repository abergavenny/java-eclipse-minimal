package abergavenny.minimal.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RootPerspective implements IPerspectiveFactory {
	public static final String ID = "abergavenny.minimal.ui.rootperspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		System.out.println("Perspective.createInitialLayout");
		layout.setEditorAreaVisible(true);

		layout.addStandaloneView("abergavenny.minimal.ui.components.designer.BasicViewPart", false, IPageLayout.LEFT,
				0.25f, layout.getEditorArea());

//		layout.addStandaloneView(RootView.ID, false, IPageLayout.LEFT, 0.25f, layout.getEditorArea());
//		layout.getViewLayout(RootView.ID).setCloseable(false);
//		layout.getViewLayout(RootView.ID).setMoveable(false);
	}
}
