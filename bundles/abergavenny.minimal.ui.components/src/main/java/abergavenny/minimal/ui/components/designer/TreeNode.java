package abergavenny.minimal.ui.components.designer;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private String name;
	private List<TreeNode> children = new ArrayList<>();

	public TreeNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void addChild(TreeNode child) {
		children.add(child);
	}
}