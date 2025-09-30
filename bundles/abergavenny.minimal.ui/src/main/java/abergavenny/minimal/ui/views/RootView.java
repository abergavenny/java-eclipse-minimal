package abergavenny.minimal.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import abergavenny.minimal.ui.components.trees.CustomTreeComponent;

public class RootView extends ViewPart {
	public static final String ID = "abergavenny.minimal.ui.views.rootview"; //$NON-NLS-1$

	CustomTreeComponent treeComponent;

	public RootView() {
	}

	public CustomTreeComponent getTreeComponent() {
		return treeComponent;
	}

	@Override
	public void createPartControl(Composite parent) {
		System.out.println("RootView.createPartControl");

		SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createComponent(sashForm);
	}

	@Override
	public void setFocus() {
	}

	private void createComponent(Composite composite) {
		treeComponent = new CustomTreeComponent(composite);
	}

}
