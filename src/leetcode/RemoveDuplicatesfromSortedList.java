package leetcode;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
//        ListNode l1_5 = new ListNode(3);
//        ListNode l1_4 = new ListNode(3, l1_5);
//        ListNode l1_3 = new ListNode(2, l1_4);
//        ListNode l1_2 = new ListNode(1, l1_3);
//        ListNode l1_1 = new ListNode(1, l1_2);
//        deleteDuplicates(l1_1);


        ListNode l2_3 = new ListNode(1);
        ListNode l2_2 = new ListNode(1, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);
        deleteDuplicates(l2_1);

    }
    //1->1->1 , 1
    //1->1->2->3->3 , 1->2->3
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode after = head;
        ListNode before = null;

        while(after != null){
            //head안에서 지금의 val과 다음의 val을 비교
            if(before != null && before.val == after.val){
                //같으면 다음 순서를 당겨온다
                before.next = after.next;
            } else {
                before = after;
            }
            after = after.next;
        }

        return head;

    }
}
