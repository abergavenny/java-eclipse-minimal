package abergavenny.minimal.ui.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class InitializationDialog extends TitleAreaDialog {

	private Combo selectCombo;

	public InitializationDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Initialization");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, true));

		Label label = new Label(container, SWT.NONE);
		label.setText("Select:");

		selectCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		selectCombo.setItems(new String[] { "Launch config A", "Launch config B" });
		selectCombo.select(0);

		return container;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

}
