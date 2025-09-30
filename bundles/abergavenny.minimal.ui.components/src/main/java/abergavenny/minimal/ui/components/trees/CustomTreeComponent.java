package abergavenny.minimal.ui.components.trees;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

public class CustomTreeComponent {

	private TreeViewer treeViewer;

	public CustomTreeComponent(Composite composite) {
		treeViewer = new TreeViewer(composite, SWT.BORDER);

		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		System.out.println("Tree: " + tree != null);
	}
}
