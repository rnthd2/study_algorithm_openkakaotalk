package leetcode;

public class SortList {
    public static void main(String[] args) {
        ListNode l2_5 = new ListNode(0);
        ListNode l2_4 = new ListNode(4, l2_5);
        ListNode l2_3 = new ListNode(3, l2_4);
        ListNode l2_2 = new ListNode(5, l2_3);
        ListNode l2_1 = new ListNode(-1, l2_2);
        sortList(l2_1);

        ListNode l1_4 = new ListNode(3);
        ListNode l1_3 = new ListNode(1, l1_4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(4, l1_2);
        sortList(l1_1);

    }

    /**
     *
     * merge sort
     * O(nlogn) time, O(1) memory
     *
     * 4->2->1->3
     * 1->2->3->4
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;    //merge sort의 왼쪽의 끝
        ListNode slow = head;   //merge sort의 오른쪽의 시작
        /**
         * middle 노드를 찾는 기준점
         * pre와 slow가 중간지점에 왔을 때 while문 종료
         */
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //왼쪽과 오른쪽을 구분하기 위해 왼쪽 이후 부분을 null 처리
        pre.next = null;

        //재귀 merge
        return merge(sortList(head), sortList(slow));
    }

    /**
     * val 기준 오름차순으로 merge
     * @param left
     * @param right
     * @return
     */
    static ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val > right.val){
            left.next = right.next;
            right.next = left;
        }
        return left;
    }
}
