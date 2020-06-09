package data.structure.nonlinear.tree;

import java.util.ArrayList;

public class DefaultTree {
	static ArrayList<Node> leafNodeList = new ArrayList<>();

	public static void main(String[] args) {
		//create root node
		Node root = new Node(null);

		//stage 2
		Node node1 = new Node(root);
		root.getChildren().add(node1);

		//stage 3
		Node node2 = new Node(root);
		root.getChildren().add(node2);

		//stage 4
		Node node3 = new Node(node1);
		node1.getChildren().add(node3);

		//stage 5
		Node node4 = new Node(node1);
		node1.getChildren().add(node4);

		//stage 6(node2 remove)
		root.getChildren().remove(node2);

		//stage 7
		int leafNodeNum = findLeafNode(root).size();
		System.out.println(leafNodeNum);
	}

	static ArrayList<Node> findLeafNode(Node node){

		for (Node child : node.getChildren()) {
			if(child.getChildren().size() < 1){
				leafNodeList.add(child);
			}
			else{
				findLeafNode(child);
			}
		}
		return leafNodeList;
	}

}
