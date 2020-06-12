//package data.structure.nonlinear.tree;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//import java.util.stream.IntStream;
//
//public class TraversalTree {
//
//	static ArrayList<TraversalNode> nodeList = new ArrayList<>();
//
//	static ArrayList test1_pre_order = new ArrayList(Arrays.asList(27, 16, 9, 12, 54, 36, 72));  //전위
//	static ArrayList test1_in_order = new ArrayList(Arrays.asList(9, 12, 16, 27, 36, 54, 72));   //중위
//	static TraversalNode root = null;
//	static Stack<TraversalNode> stack = new Stack<>();
//
//	public static void main(String[] args) {
//
//		int root_num = 3;
//		root = new TraversalNode(null, test1_pre_order.get(0));
//		root = test1(root, null, root_num);
//		nodeList.add(root);
//
//		int node1_num = 2;
//		TraversalNode node1 = new TraversalNode(root, test1_pre_order.get(1));
//		node1 = test2(node1, root_num, node1_num);
//		nodeList.add(node1);
//
//		int node2_num = 0;
//		TraversalNode node2 = new TraversalNode(node1, test1_pre_order.get(2));
//		node2 = test2(node2, node1_num, node2_num);
//		nodeList.add(node2);
//
//		int node3_num = 1;
//		TraversalNode node3 = new TraversalNode(node2, test1_pre_order.get(3));
//		//non child node
//		if (root.getLeft_children().size() == nodeList.size() - root.getRight_children().size()) {
//			node3 = test2(node3, node2_num, node3_num);
//			nodeList.add(node3);
//		}
//
//		int node4_num = 5;
//		TraversalNode node4 = new TraversalNode(root, test1_pre_order.get(4));
//		node4 = test3(node4, root_num, node4_num);
//		nodeList.add(node4);
//
//		int node5_num = 4;
//		TraversalNode node5 = new TraversalNode(node4, test1_pre_order.get(5));
//		node5 = test3(node5, node4_num, node5_num);
//		nodeList.add(node5);
//
//		int node6_num = 6;
//		TraversalNode node6 = new TraversalNode(node4, test1_pre_order.get(6));
//		if (root.getRight_children().size() == nodeList.size() - root.getLeft_children().size()) {
//			node6 = test3(node6, node4_num, node6_num);
//			nodeList.add(node6);
//		}
//	}
//
//	static TraversalNode test1(TraversalNode node, Integer parent_num, Integer num) {
//
//		for (int i = 0; i < test1_in_order.size(); i++) {
//			if (i < num) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getLeft_children().add(addNode);
//			} else if (i > num ) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getRight_children().add(addNode);
//			} else {
//				continue;
//			}
//		}
//		return node;
//	}
//
//	static TraversalNode test2(TraversalNode node, Integer parent_num, Integer num) {
//
//		for (int i = 0; i < test1_in_order.size(); i++) {
//			if (i < num) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getLeft_children().add(addNode);
//			} else if (i > num && i < parent_num) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getRight_children().add(addNode);
//			} else {
//				continue;
//			}
//		}
//		return node;
//	}
//
//	static TraversalNode test3(TraversalNode node, Integer parent_num, Integer num) {
//
//		for (int i = 0; i < test1_in_order.size(); i++) {
//			if (parent_num < i && i < num) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getLeft_children().add(addNode);
//			} else if (parent_num < i && num < i) {
//				TraversalNode addNode = new TraversalNode(root, test1_in_order.get(i));
//				node.getRight_children().add(addNode);
//			} else {
//				continue;
//			}
//		}
//		return node;
//	}
//}
