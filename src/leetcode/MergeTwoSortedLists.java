package leetcode;

public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		//		Input: 1->2->4, 1->3->4
		//		Output: 1->1->2->3->4->4
		ListNode node1_4 = new ListNode(4);
		ListNode node1_2 = new ListNode(2, node1_4);
		ListNode node1_1 = new ListNode(1, node1_2);

		ListNode node2_4 = new ListNode(4);
		ListNode node2_3 = new ListNode(3, node2_4);
		ListNode node2_1 = new ListNode(1, node2_3);

		mergeTwoLists(node1_1, node2_1);
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		while(n1 != null || n2 != null){
			ListNode node = new ListNode(n2.val, n1.next);
			n1.next = node;
			n1 = n1.next.next;
			n2 = n2.next;
		}
		return l1;
	}
}
