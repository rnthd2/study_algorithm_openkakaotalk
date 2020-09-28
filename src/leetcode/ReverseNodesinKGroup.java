package leetcode;

import java.util.Stack;

public class ReverseNodesinKGroup {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		//		ListNode node1 = new ListNode();
		//		ListNode node1 = new ListNode(1);
		//		ListNode node1 = null;
		System.out.println(reverseKGroup(node1, 2));
	}

	//1->2->3->4->5 , 2 is 2->1->4->3->5
	//1->2->3->4->5 , 3 is 3->2->1->4->5
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode result = new ListNode(-1);
		ListNode temp = new ListNode(-1);
		Stack<Integer> stack = new Stack<>();

		while (temp != null) {
			ListNode node = result;

			for (int i = 0; i < k; i++) {
				if(head == null){
					//reverse stack
					stack = reverseStack(stack);
					temp = null;
					break;
				}
				if (i == k - 1)
					temp = head.next;
				stack.push(head.val);
				head = head.next;
				if (result.next != null)
					node = node.next;
			}

			while (!stack.empty()) {
				if (node.val > -1) {
					node.next = new ListNode(stack.pop());
					node = node.next;
				} else
					node.val = stack.pop();
			}
		}

		return result;
	}
	static Stack reverseStack(Stack stack){
		Stack newStack = new Stack();
		while(!stack.empty())
			newStack.push(stack.pop());
		return newStack;
	}
	//
	//	void test(int val, ListNode next){
	////		new ListNode(1);
	////		new ListNode(2, node1);
	////		new ListNode(3, node2);
	//		new ListNode(1);
	//		test(2, new ListNode(1));
	//
	//	}
}
