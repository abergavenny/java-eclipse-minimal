package abergavenny.minimal.ui.components.designer;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class BasicMasterDetailsBlock extends MasterDetailsBlock {

	private FormToolkit toolkit;

	/**
	 * Create the master details block.
	 */
	public BasicMasterDetailsBlock() {
		// Create the master details block
	}

	/**
	 * Create contents of the master details block.
	 *
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(IManagedForm managedForm, Composite parent) {
		toolkit = managedForm.getToolkit();

		parent.setLayout(new GridLayout(1, false));
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Section section = toolkit.createSection(parent, Section.TITLE_BAR | Section.EXPANDED);
		section.setText("Master Section");
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite composite = toolkit.createComposite(section, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		section.setClient(composite);

		TreeViewer treeViewer = new TreeViewer(composite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(false);

		// IMPORTANT: give the tree a GridData that fills but also has an initial
		// heightHint
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.heightHint = 100; // initial "max" height — tweak as needed
		gd.minimumHeight = 50; // minimum sensible height
		tree.setLayoutData(gd);

		populateTreeViewer(treeViewer);

		// treeViewer.setAutoExpandLevel(1); // auto-expand top-level only
		treeViewer.expandAll(); // <-- removed (caused excessive preferred size)

		composite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle area = composite.getClientArea();
				GridData g = (GridData) tree.getLayoutData();

				int newHint = Math.max(g.minimumHeight, area.height - 6);
				if (g.heightHint != newHint) {
					g.heightHint = newHint;
					composite.layout();
				}
			}
		});
	}

	/**
	 * Register the pages.
	 *
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		// Register the pages
	}

	/**
	 * Create the toolbar actions.
	 *
	 * @param managedForm
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// Create the toolbar actions
	}

	private void populateTreeViewer(TreeViewer treeViewer) {
		// Content provider (traverse TreeNode model)
		treeViewer.setContentProvider(new org.eclipse.jface.viewers.ITreeContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof TreeNode[]) {
					return (TreeNode[]) inputElement;
				}
				return new Object[0];
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof TreeNode) {
					return ((TreeNode) parentElement).getChildren().toArray();
				}
				return new Object[0];
			}

			@Override
			public Object getParent(Object element) {
				return null; // Not needed for simple example
			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof TreeNode && !((TreeNode) element).getChildren().isEmpty();
			}
		});

		// Label provider (text for each node)
		treeViewer.setLabelProvider(new org.eclipse.jface.viewers.LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TreeNode) {
					return ((TreeNode) element).getName();
				}
				return super.getText(element);
			}
		});

		// Create some sample data
		TreeNode root1 = new TreeNode("Root 1");
		root1.addChild(new TreeNode("Child 1.1"));
		root1.addChild(new TreeNode("Child 1.2"));

		TreeNode root2 = new TreeNode("Root 2");
		TreeNode child21 = new TreeNode("Child 2.1");
		child21.addChild(new TreeNode("Grandchild 2.1.1"));
		root2.addChild(child21);

		TreeNode root3 = new TreeNode("Root 3");
		root3.addChild(new TreeNode("Child 3.1"));
		root3.addChild(new TreeNode("Child 3.2"));
		root3.addChild(new TreeNode("Child 3.3"));

		TreeNode root4 = new TreeNode("Root 4");

		TreeNode root5 = new TreeNode("Root 5");

		// Set input
		treeViewer.setInput(new TreeNode[] { root1, root2, root3, root4, root5, root1, root1, root1, root1 });

		// Expand all by default
		treeViewer.expandAll();
	}
}
