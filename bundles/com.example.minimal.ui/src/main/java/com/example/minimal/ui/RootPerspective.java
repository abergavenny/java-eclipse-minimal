package com.example.minimal.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RootPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// Optional: define layout, or leave empty for a blank perspective
		layout.setEditorAreaVisible(false);
	}
}
