package abergavenny.minimal.ui.components.designer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

public class BasicViewPart extends ViewPart {

	public static final String ID = "abergavenny.minimal.ui.components.designer.BasicViewPart"; //$NON-NLS-1$

	FormToolkit toolkit;
	Form form;
	ScrolledForm scrolledForm;

	public BasicViewPart() {
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		toolkit = new FormToolkit(parent.getDisplay());

		scrolledForm = toolkit.createScrolledForm(parent);
		scrolledForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scrolledForm.setText("Scrolled Form");
		scrolledForm.setExpandHorizontal(true);
		scrolledForm.setExpandVertical(true);

		ManagedForm managedForm = new ManagedForm(toolkit, scrolledForm);
		scrolledForm.getBody().setLayout(new GridLayout(1, false));

		BasicMasterDetailsBlock block = new BasicMasterDetailsBlock();
		block.createContent(managedForm);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
