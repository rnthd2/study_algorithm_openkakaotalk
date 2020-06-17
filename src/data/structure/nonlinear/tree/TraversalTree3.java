package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TraversalTree3 {

	static ArrayList<TraversalNode> nodeList = new ArrayList<>();

	static ArrayList test1_pre_order = new ArrayList(Arrays.asList(27, 16, 9, 12, 54, 36, 72));  //전위
	static ArrayList test1_in_order = new ArrayList(Arrays.asList(9, 12, 16, 27, 36, 54, 72));   //중위
	static TraversalNode root = null;

	public static void main(String[] args) {

		for (int i = 0; i < test1_pre_order.size(); i++) {
			setChildrenByRoot(i);
		}

		post_order().forEach(element -> System.out.println(element));

	}

	static void setChildrenByRoot(int pre_order_num) {
		//전위순회 순으로 진행
		TraversalNode node = new TraversalNode(test1_pre_order.get(pre_order_num));

		//root node를 제외하고
		// 부모 노드를 세팅하고, 부모 노드 기준 내가 왼쪽인지 오른쪽인지 세팅

		//todo 내가 루트인지, 루트 왼쪽인지, 루트 오른쪽인지 생각한다
		int start = 0;
		int end = test1_in_order.size();

		if(pre_order_num > 0){
			//내가 자식인 노드를 찾고
			for (TraversalNode parent : nodeList) {
				if(parent.getLeft_children().contains(node.getElement())) {
					parent.setLeft_child(node);
					node.setParent(parent);
					end = nodeList.get(0).getIn_order_num();
					break;
				} else if(parent.getRight_children().contains(node.getElement())) {
					parent.setRight_child(node);
					node.setParent(parent);
					start = nodeList.get(0).getIn_order_num()+1;
					break;
				} else {
					System.out.println("non father! node is " + node.getElement());
				}
			}
		}

		//중위순회에서 node의 위치를 가져옴
		for (int i = 0; i < test1_in_order.size(); i++) {
			if(test1_in_order.get(i) == node.getElement()){
				node.setIn_order_num(i);
			}
		}

		//중위순회에서 node를 기준으로 왼쪽 자식/오른쪽 자식을 세팅
		ArrayList left_in_order = new ArrayList(test1_in_order.subList(start, node.getIn_order_num()));
		ArrayList right_in_order = new ArrayList(test1_in_order.subList(node.getIn_order_num() + 1, end));

		left_in_order.removeIf(TraversalTree3::checkParent);
		right_in_order.removeIf(TraversalTree3::checkParent);

		for (Object o : left_in_order) {
			for (TraversalNode traversalNode : nodeList) {
				if (traversalNode.getElement() == o) left_in_order.remove(o);
			}
		}

		node.getLeft_children().addAll(left_in_order);
		node.getRight_children().addAll(right_in_order);

		//결과물에 넣기
		nodeList.add(node);
	}


	/**
	 * void post_order(Node *node) {
	 if (node->left != NULL) post_order(node->left);
	 if (node->right != NULL) post_order(node->right);
	 printf("%d ", node->value);
	 }
	 */
	//todo 후위순회 만들기
	static ArrayList post_order(){
		return null;
	}

	//todo 버그 체크 필요
	private static boolean checkParent(Object obj) {
		for (TraversalNode traversalNode : nodeList) {
			return traversalNode.getElement().equals(obj) ? true : false;
		}
		return false;
	}
}
