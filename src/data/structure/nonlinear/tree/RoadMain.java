package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RoadNode {
	Object element;
	int x;
	int y;
	RoadNode left;
	RoadNode right;
	RoadNode parent;

	public RoadNode(Object element, int x, int y) {
		this.element = element;
		this.x = x;
		this.y = y;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLeft(RoadNode left) {
		this.left = left;
	}

	public void setRight(RoadNode right) {
		this.right = right;
	}

	public RoadNode getParent() {
		return parent;
	}

	public void setParent(RoadNode parent) {
		this.parent = parent;
	}
}

class RoadTree {

	RoadNode root;
	List<RoadNode> tree;

	public RoadNode getRoot() {
		return root;
	}

	public void setRoot(RoadNode root) {
		this.root = root;
	}

	public List<RoadNode> getTree() {
		return tree;
	}

	public RoadNode createNode(Object element, int x, int y) {
		RoadNode node = new RoadNode(element, x, y);
		if(tree == null){
			tree = new ArrayList<>();
		}
		tree.add(node);
		return node;
	}

	//전위순회
	void preOrder(RoadNode node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.println(node.element);
		}
	}

	//후위순회
	public void postOrder(RoadNode node) {
		if(node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.println(node.element);
		}
	}

	//중위순회
	public void inOrder(RoadNode node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.element);
			inOrder(node.right);
		}
	}
}

public class RoadMain {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};

		RoadTree tree = new RoadTree();

		//node 생성
		for (int i = 0; i < nodeinfo.length; i++) {
			tree.createNode(i+1, nodeinfo[i][0], nodeinfo[i][1]);
		}

		List<RoadNode> nodeList = tree.getTree();

		//y값 오름차순으로 정렬
		Collections.sort(nodeList, (o1, o2) -> o2.getY() > o1.getY() ? 1 : -1);

		//set left child, right child
		int num = 0;
		int parentNum = 0;
		tree.setRoot(nodeList.get(num));
		RoadNode parent = tree.getRoot();

		do{
			num+=setChildren(parent , nodeList.get(num), nodeList.get(++num));
			//todo parent 변경
			parent = nodeList.get(num);
		} while(num < nodeList.size());

		tree.preOrder(tree.getRoot());

		return answer;
	}

	static int setChildren(RoadNode parent, RoadNode node1, RoadNode node2) {
		// root 인경우
		if (parent.getParent() == null ||
				//node1과 node2의 y값이 같고 부모가 같은 경우
				node1.getY() == node2.getY() && minXByParents(node1) == minXByParents(node2)) {
			if (node1.getX() < parent.getX() && parent.getX() < node2.getX()){
				parent.setLeft(node1);
				parent.setRight(node2);
			} else {
				parent.setLeft(node2);
				parent.setRight(node1);
			}
			node1.setParent(parent);
			node2.setParent(parent);
			return 2;   //node1,2 set 완료
		} else {
			//node1과 node2의 부모가 다른경우
			//node1과 node2가 y값이 같고 부모가 다른 경우
			setChild(parent, node1);
			node1.setParent(parent);
			return 1;   //node1 set 완료
		}
	}

	static RoadNode setChild(RoadNode parent, RoadNode node) {
		if (node.getX() < parent.getX() ){
			parent.setLeft(node);
		} else {
			parent.setRight(node);
		}
		return node;
	}

	static int min = 0;
	static int minXByParents(RoadNode node){
		if(node.getParent() == null){
			return min;
		} else {
			if(node.getParent().getX() < min){
				min = node.getParent().getX();
			}
			return minXByParents(node.getParent());
		}
	}

}
