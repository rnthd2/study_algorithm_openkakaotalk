package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class DefaultTree {
	static ArrayList<Node> leafNodeList = new ArrayList<>();
	static Node root = null;

	public static void main(String[] args) {
		int n = 5;
		String str = "-1 0 0 1 1";
		String[] list = str.split(" ");

		for (int i = 0; i < n; i++) {
			int parentEle = Integer.valueOf(list[i]);
			if (parentEle < 0) {
				root = new Node(null, i);
			} else {
				Node parentNode = findNodeByNodeAndElement(root, parentEle);
				addNode(parentNode, i);
			}
		}

		removeNodeByNumber(2);

		System.out.println(findLeafNode(root).size());
	}

	static void addNode(Node parentNode, Object element){
		Node node = new Node(parentNode, element);
		parentNode.getChildren().add(node);
	}

	static void removeNodeByNumber(int num){
		Node removeNode = findNodeByNodeAndElement(root, num);
		root.getChildren().remove(removeNode);
	}

	static Node findNodeByNodeAndElement(Node node, Object element){
		Node findNode = null;
		for (Node child : node.getChildren()) {
			if(child.getElement() == element) {
				findNode = child;
			} else {
				findNodeByNodeAndElement(child, element);
			}
		}
		return findNode;
	}

	static ArrayList<Node> findLeafNode(Node node) {
		for (Node child : node.getChildren()) {
			if (child.getChildren().size() < 1) {
				leafNodeList.add(child);
			} else {
				findLeafNode(child);
			}
		}
		return leafNodeList;
	}

}
