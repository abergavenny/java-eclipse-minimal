package com.example.minimal.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class RootView extends ViewPart {

	public static final String ID = "com.example.minimal.ui.rootview";

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());

		new Label(parent, SWT.NONE).setText("😭");
	}

	@Override
	public void setFocus() {
		// Called when the view receives focus
	}
}
