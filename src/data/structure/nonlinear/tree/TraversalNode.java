package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class TraversalNode extends Node {

	private int in_order_num;

	private TraversalNode left_child;
	private TraversalNode right_child;

	private ArrayList<Object> left_children;
	private ArrayList<Object> right_children;

	public TraversalNode(Object element) {
		super(null, element);
		left_children = new ArrayList<>();
		right_children = new ArrayList<>();
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

	public int getIn_order_num() {
		return in_order_num;
	}

	public void setIn_order_num(int in_order_num) {
		this.in_order_num = in_order_num;
	}
}
