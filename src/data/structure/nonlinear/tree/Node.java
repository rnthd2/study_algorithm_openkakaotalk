package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class Node {
	private Object element;
	private Node parent;
	private ArrayList children;

	//root node create
	public Node(Object element) {
		this.element = element;
		this.parent = null;
		this.children = new ArrayList();
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList getChildren() {
		return children;
	}
}
