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
				Node parentNode = findNodeByElement(parentEle);
				Node node = new Node(parentNode, i);
				parentNode.getChildren().add(node);
			}
		}
		Object removeNum = 2;
		Node removeNode = findNodeByElement(removeNum);
		root.getChildren().remove(removeNode);

		int leafNodeNum = findLeafNode(root).size();
		System.out.println(leafNodeNum);
	}

	static Node findNodeByElement(Object element) {
		if(root.getElement() == element) return root;
		else {
			for (Node child : root.getChildren()) {
				Node findNode = findNodeByNodeAndElement(child, element);
				if (findNode != null) {
					return findNode;
				}
			}
		}
		return null;
	}
	static Node findNodeByNodeAndElement(Node node, Object element) {
		if(node.getElement() == element) return node;
		else {
			for (Node child : node.getChildren()) {
				if(child.getElement() == element) return child;
				else{
					return findNodeByNodeAndElement(child, element);
				}
			}
		}
		return null;
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
