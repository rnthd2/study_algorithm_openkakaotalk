package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class DefaultTree {

	private static Node root;
	private static ArrayList<Node> nodeList;

	public DefaultTree(Object element) {
		this.root = new Node(element);
		this.nodeList = new ArrayList<>();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if (n > 0 ) addRootNode(0);

		String[] str = sc.next().split(" ");
		for (int i = 0; i < n; i++) {
			int a = Integer.valueOf(str[i]);
			//todo getNode(a)가 루트라면?
			addNode(getNode(a), i);
		}

		removeNode(getNode(sc.next()));

	}
	static void addRootNode(Object element){
		new DefaultTree(element);
	}

	static void addNode(Node parent, Object element){
		Node node = new Node(element);
		node.setParent(parent);
		node.getChildren().add(node);
		nodeList.add(node);
	}

	static void removeNode(Node node){
		nodeList.remove(node);
		node.getChildren().remove(node);
	}

	static Node getNode(Object element){
		if((int)element == -1)
			return root;
		else {
			return nodeList.get((int)element);
		}
	}
}
