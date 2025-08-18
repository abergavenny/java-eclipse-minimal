package abergavenny.minimal.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import abergavenny.minimal.ui.Messages;

public class RootView extends ViewPart {

	public static final String ID = "abergavenny.minimal.ui.views.rootview"; //$NON-NLS-1$

	@Override
	public void createPartControl(Composite parent) {
		System.out.println("RootView.createPartControl");
		Label label = new Label(parent, SWT.NONE);
		label.setText(ID + " " + Messages.hello);
	}

	@Override
	public void setFocus() {
	}

}
