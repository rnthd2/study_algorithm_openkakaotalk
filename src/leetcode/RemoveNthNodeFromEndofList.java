package leetcode;

public class RemoveNthNodeFromEndofList {
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
//		ListNode node5 = new ListNode(5);
//		ListNode node4 = new ListNode(4, node5);
//		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1, node2);
		removeNthFromEnd(node1, 1);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		//마지막 노드가 몇 번째인지 확인
		ListNode node = new ListNode(0, head);
		int num = 0;
		while(node.next != null){
			node = node.next;
			num++;
		}

		if (head == null)
			return null;
		else {
			//첫 노드를 삭제하는 경우
			if (num - n == 0) {
				return head.next;
			}
			//그 외 노드를 삭제하는 경우
			else {
				num-=n;
				ListNode temp = head;
				while (temp != null && num > 1) {
					temp = temp.next;
					--num;
				}
				temp.next = temp.next.next;
			}
		}
		return head;
	}
}


