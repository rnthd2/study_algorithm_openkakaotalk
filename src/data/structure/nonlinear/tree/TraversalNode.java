package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class TraversalNode extends Node{

	private ArrayList<TraversalNode> left_children;
	private ArrayList<TraversalNode> right_children;

	public TraversalNode(Node parent, Object element) {
		super(parent, element);
		left_children = new ArrayList<>();
		right_children = new ArrayList<>();
	}

	public ArrayList<TraversalNode> getLeft_children() {
		return left_children;
	}

	public void setLeft_children(ArrayList<TraversalNode> left_children) {
		this.left_children = left_children;
	}

	public ArrayList<TraversalNode> getRight_children() {
		return right_children;
	}

	public void setRight_children(ArrayList<TraversalNode> right_children) {
		this.right_children = right_children;
	}
}
