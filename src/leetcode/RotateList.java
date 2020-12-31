package leetcode;

import java.util.LinkedList;

public class RotateList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(rotateRight(node1, 2).toString());
    }

    /**
     * 1->2->3->4->5 , 1 is 5->1->2->3->4
     * 1->2->3->4->5 , 2 is 4->5->1->2->3
     *
     * 0->1->2, 1 is 2->0->1**
     * 0->1->2, 2 is 1->2->0
     * 0->1->2, 3 is 0->1->2
     * 0->1->2, 4 is 2->0->1**
     * 0->1->2, 7 is 2->0->1**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 1){
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        int count = 0;

        while(first.next != null){
            first = first.next;
            count++;
        }

        int shift = count-(k%count);

        while(shift-- > 0){
            second = second.next;
        }

        first.next = head;
        head = second.next;
        second.next = null;

        return head;
    }

    public static ListNode test(ListNode head, int k) {
        if(head == null || k < 1){
            return head;
        }

        LinkedList<Integer> list = new LinkedList<>();

        do{
            list.add(head.val);
            head = head.next;
        } while(head != null);

        //회전 알고리즘이기에 list.size만큼 같은 결과가 나온다
        int count = k % list.size();
        count = (count > 0)? count : list.size();
        while(--count >= 0) {
            list.addFirst(list.removeLast());
        }

        head = new ListNode(list.getFirst());
        ListNode node = head;

        for (int i = 1; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }

        return head;
    }

}
