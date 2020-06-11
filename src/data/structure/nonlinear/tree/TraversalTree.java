package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TraversalTree {

	static ArrayList<Node> nodeList = new ArrayList<>();

	static ArrayList test1_pre_order = new ArrayList(Arrays.asList(27,16,9,12,54,36,72));  //전위
	static ArrayList test1_in_order = new ArrayList(Arrays.asList(9,12,16,27,54,36,72));   //중위
	static TraversalNode root = null;

	public static void main(String[] args) {
		root = new TraversalNode(null, test1_pre_order.get(0));

		root = test();
		nodeList.add(root);

		TraversalNode node1 = new TraversalNode(root, test1_pre_order.get(1));
		node1 = test2(node1);
		nodeList.add(node1);

		TraversalNode node2 = new TraversalNode(node1, test1_pre_order.get(2));
		node2 = test3(node2);
		nodeList.add(node2);

		TraversalNode node3 = new TraversalNode(node2, test1_pre_order.get(3));
		node3 = test4(node3);
		nodeList.add(node3);

		TraversalNode node4 = new TraversalNode(root, test1_pre_order.get(4));
		node4 = test5(node4);
		nodeList.add(node4);

		TraversalNode node5 = new TraversalNode(node4, test1_pre_order.get(5));
		node5 = test6(node5);
		nodeList.add(node5);

		TraversalNode node6 = new TraversalNode(node5, test1_pre_order.get(6));
		node6 = test7(node6);
		nodeList.add(node6);


	}
	static TraversalNode test(){

		TraversalNode node0 = new TraversalNode(root, test1_in_order.get(0));
		TraversalNode node1 = new TraversalNode(root, test1_in_order.get(1));
		TraversalNode node2 = new TraversalNode(root, test1_in_order.get(2));

		//stage 3 left child
		root.getLeft_children().add(node0);
		root.getLeft_children().add(node1);
		root.getLeft_children().add(node2);


		TraversalNode node4 = new TraversalNode(root, test1_in_order.get(4));
		TraversalNode node5 = new TraversalNode(root, test1_in_order.get(5));
		TraversalNode node6 = new TraversalNode(root, test1_in_order.get(6));

		//stage 3 right child
		root.getRight_children().add(node4);
		root.getRight_children().add(node5);
		root.getRight_children().add(node6);


		return root;
	}

	static TraversalNode test2(TraversalNode node){

		TraversalNode node0 = new TraversalNode(node, test1_in_order.get(0));
		TraversalNode node1 = new TraversalNode(node, test1_in_order.get(1));

		//stage 3 left child
		node.getLeft_children().add(node0);
		node.getLeft_children().add(node1);

		return node;
	}

	static TraversalNode test3(TraversalNode node){

		TraversalNode node1 = new TraversalNode(node, test1_in_order.get(1));

		//stage 3 right child
		node.getRight_children().add(node1);

		return node;
	}

	static TraversalNode test4(TraversalNode node){
		//non child node
		return node;
	}

	static TraversalNode test5(TraversalNode node){

		TraversalNode node4 = new TraversalNode(root, test1_in_order.get(4));
		TraversalNode node5 = new TraversalNode(root, test1_in_order.get(5));
		TraversalNode node6 = new TraversalNode(root, test1_in_order.get(6));

		//stage 3 right child
		node.getRight_children().add(node4);
		node.getRight_children().add(node5);
		node.getRight_children().add(node6);

		return node;
	}

	static TraversalNode test6(TraversalNode node){

		TraversalNode node5 = new TraversalNode(root, test1_in_order.get(5));

		//stage 3 left child
		node.getLeft_children().add(node5);

		return node;
	}

	static TraversalNode test7(TraversalNode node){

		TraversalNode node6 = new TraversalNode(root, test1_in_order.get(6));

		//stage 3 right child
		node.getRight_children().add(node6);

		return node;
	}
}
