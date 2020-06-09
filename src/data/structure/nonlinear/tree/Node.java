package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Object element;
	private Node parent;
	private List<Node> children;

	public Node(Node parent, Object element) {
		this.element = element;
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

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
}
