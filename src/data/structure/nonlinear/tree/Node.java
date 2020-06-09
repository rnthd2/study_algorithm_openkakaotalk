package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Node parent;
	private List<Node> children;

	public Node(Node parent) {
		this.parent = parent;
		this.children = new ArrayList<>();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

}
