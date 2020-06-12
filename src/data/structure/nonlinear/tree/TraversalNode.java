package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class TraversalNode extends Node {

	private boolean is_left_child;
	private boolean is_right_child;

	private TraversalNode left_child;
	private TraversalNode right_child;

	private ArrayList<Object> left_children;
	private ArrayList<Object> right_children;

	public TraversalNode(Object element) {
		super(null, element);
		left_children = new ArrayList<>();
		right_children = new ArrayList<>();
		is_left_child = false;
		is_right_child = false;
	}

	public TraversalNode getLeft_child() {
		return left_child;
	}

	public void setLeft_child(TraversalNode left_child) {
		this.left_child = left_child;
	}

	public TraversalNode getRight_child() {
		return right_child;
	}

	public void setRight_child(TraversalNode right_child) {
		this.right_child = right_child;
	}

	public boolean isIs_left_child() {
		return is_left_child;
	}

	public void setIs_left_child(boolean is_left_child) {
		this.is_left_child = is_left_child;
	}

	public boolean isIs_right_child() {
		return is_right_child;
	}

	public void setIs_right_child(boolean is_right_child) {
		this.is_right_child = is_right_child;
	}

	public ArrayList<Object> getLeft_children() {
		return left_children;
	}

	public void setLeft_children(ArrayList<Object> left_children) {
		this.left_children = left_children;
	}

	public ArrayList<Object> getRight_children() {
		return right_children;
	}

	public void setRight_children(ArrayList<Object> right_children) {
		this.right_children = right_children;
	}
}
