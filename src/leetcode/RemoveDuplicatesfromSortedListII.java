package leetcode;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode l1_7 = new ListNode(5);
        ListNode l1_6 = new ListNode(4, l1_7);
        ListNode l1_5 = new ListNode(4, l1_6);
        ListNode l1_4 = new ListNode(3, l1_5);
        ListNode l1_3 = new ListNode(3, l1_4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(1, l1_2);
        deleteDuplicates(l1_1);
//
//        ListNode l2_5 = new ListNode(3);
        ListNode l2_4 = new ListNode(2);
        ListNode l2_3 = new ListNode(1, l2_4);
        ListNode l2_2 = new ListNode(1, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);
        deleteDuplicates(l2_1);

        ListNode l3_2 = new ListNode(1);
        ListNode l3_1 = new ListNode(1, l3_2);
        deleteDuplicates(l3_1);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode end = head; //중복체크 끝
        ListNode start = null; //중복체크 시작
        ListNode connect = null; //중복체크 시작 직전

        while(end != null){
            if(start != null){
                if(start.val == end.val){
                    //속도 향상을 위한 중복체크
                    while(end.next != null && start.val == end.next.val){
                        end = end.next;
                    }
                    if(connect != null){
                        connect.next = end.next;
                    } else {
                        head = end.next;
                    }
                    start = null;
                } else {
                    connect = start;
                    start = start.next;
                }
            } else {
                start = end;
            }
            end = end.next;
        }
        return head;
    }
}
