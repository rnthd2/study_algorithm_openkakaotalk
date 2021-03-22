package leetcode;

public class SwapNodesinPairs {
	public static void main(String[] args) {
//		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
//		ListNode node1 = new ListNode();
//		ListNode node1 = new ListNode(1);
//		ListNode node1 = null;
		System.out.println(swapPairs(node1));
	}

	//1->2->3->4 swap 2->1->4->3
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		ListNode result = new ListNode();
		ListNode temp = result;

		while(head != null) {
			//주어진 node 개수가 홀수인 경우, 마지막 반복문에서 자른다
			if(head.next == null){
				temp.val = temp.next.val;
				temp.next = null;
				break;
			}

			//swap
			temp.val = head.next.val;
			temp.next = head;

			//다음 head 초기화
			head = head.next.next;

			//마지막 node인 경우, next값을 null처리한다
			if(head == null)
				temp.next.next = null;

			//다음 temp 초기화
			temp = temp.next.next;
		}

		return result;
	}
}
