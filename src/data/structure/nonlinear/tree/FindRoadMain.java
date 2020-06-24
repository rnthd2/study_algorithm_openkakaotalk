package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FindRoadNode {
	Object element;
	int x;
	int y;
	FindRoadNode left;
	FindRoadNode right;
	List<FindRoadNode> leftChildren;
	List<FindRoadNode> rightChildren;
	FindRoadNode parent;

	public FindRoadNode(Object element, int x, int y) {
		this.element = element;
		this.x = x;
		this.y = y;
		this.leftChildren = new ArrayList<>();
		this.rightChildren = new ArrayList<>();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<FindRoadNode> getLeftChildren() {
		return leftChildren;
	}

	public List<FindRoadNode> getRightChildren() {
		return rightChildren;
	}

	public void setLeftChildren(List<FindRoadNode> leftChildren) {
		this.leftChildren = leftChildren;
	}

	public void setRightChildren(List<FindRoadNode> rightChildren) {
		this.rightChildren = rightChildren;
	}

	public void setLeft(FindRoadNode left) {
		this.left = left;
	}

	public void setRight(FindRoadNode right) {
		this.right = right;
	}

	public FindRoadNode getParent() {
		return parent;
	}

	public void setParent(FindRoadNode parent) {
		this.parent = parent;
	}
}

class FindRoadTree {

	FindRoadNode root;
	List<FindRoadNode> tree;

	public List<FindRoadNode> getTree() {
		return tree;
	}

	public void setTree(List<FindRoadNode> tree) {
		this.tree = tree;
	}

	public FindRoadNode createNode(Object element, int x, int y) {
		FindRoadNode node = new FindRoadNode(element, x, y);
		if (tree == null) {
			tree = new ArrayList<>();
		}
		tree.add(node);
		return node;
	}

	//전위순회
	ArrayList preOrderResult = new ArrayList();
	void preOrder(FindRoadNode node) {
		if (node != null) {
			preOrderResult.add(node.element);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//후위순회
	ArrayList postOrderResult = new ArrayList();
	public void postOrder(FindRoadNode node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			postOrderResult.add(node.element);
		}
	}

	//중위순회
	ArrayList inOrderResult = new ArrayList();
	public void inOrder(FindRoadNode node) {
		if (node != null) {
			inOrder(node.left);
			inOrderResult.add(node.element);
			inOrder(node.right);
		}
	}
}

public class FindRoadMain {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		System.out.println(solution(nodeinfo));
	}
	static List<FindRoadNode> nodeList = new ArrayList<>();
	static FindRoadNode root = null;

	public static int[][] solution(int[][] nodeinfo) {

		FindRoadTree tree = new FindRoadTree();

		//node 생성
		for (int i = 0; i < nodeinfo.length; i++) {
			tree.createNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}


		nodeList = tree.getTree();

		//y값 오름차순으로 정렬, y값이 같으면 x값 오름차순
		Collections.sort(nodeList, (o1, o2) -> {
			if (o2.getY() > o1.getY())
				return 1;
			else if (o2.getY() < o1.getY())
				return -1;
			else {
				if (o1.getX() > o2.getX()) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		root = nodeList.get(0);
		setChildrenAndParent(root, nodeList);

		for (int i = 1; i < nodeList.size(); i++) {
			setChildrenAndParent(nodeList.get(i), getParentChildren(nodeList.get(i)));
		}

		tree.preOrder(root);
		tree.postOrder(root);


		int[][] answer = {};
//		System.out.println(Arrays.deepToString(answer));



		return answer;

	}
	static List<FindRoadNode> getParentChildren(FindRoadNode node) {
		FindRoadNode parent = node.getParent();

		if(parent.getLeftChildren().contains(node)){
			return parent.getLeftChildren();
		} else if(parent.getRightChildren().contains(node)){
			return parent.getRightChildren();
		} else {
			return null;
		}
	}

	static void setChildrenAndParent(FindRoadNode root, List<FindRoadNode> children) {
		List<FindRoadNode> leftChildren = new ArrayList<>();
		List<FindRoadNode> rightChildren = new ArrayList<>();

		for (FindRoadNode node : children) {
			if (root.getY() > node.getY()) {
				if (root.getX() > node.getX()) {
					leftChildren.add(node);
				} else {
					rightChildren.add(node);
				}
			}
		}

		if (leftChildren.size() > 0) {
			root.setLeftChildren(leftChildren);
			FindRoadNode left = leftChildren.get(0);
			root.setLeft(left);
			left.setParent(root);
		}

		if (rightChildren.size() > 0) {
			root.setRightChildren(rightChildren);
			FindRoadNode right = rightChildren.get(0);
			root.setRight(right);
			right.setParent(root);
		}
	}
}
