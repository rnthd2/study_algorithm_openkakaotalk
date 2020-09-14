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
		//		ListNode node1_4 = new ListNode(4);
		//		ListNode node1_2 = new ListNode(2, node1_4);
		//		ListNode node1_1 = new ListNode(1, node1_2);
		//
		//		ListNode node2_4 = new ListNode(4);
		//		ListNode node2_3 = new ListNode(3, node2_4);
		//		ListNode node2_1 = new ListNode(1, node2_3);
		//
		//		mergeTwoLists(node1_1, node2_1);

		ListNode node1_1 = new ListNode();
		ListNode node2_1 = new ListNode(1);
		mergeTwoLists(node1_1, node2_1);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode node = result;

		while (l1 != null || l2 != null) {

			if (l1 != null || l1.next != null) {
				node.next = l1.next;
			}
			l1.next = node;
			l1 = l1.next.next;
			l2 = l2.next;
		}

		return l1;
	}
}
