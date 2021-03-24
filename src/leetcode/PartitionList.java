package leetcode;

public class PartitionList {
    public static void main(String[] args) {
        ListNode l1_6 = new ListNode(2);
        ListNode l1_5 = new ListNode(5, l1_6);
        ListNode l1_4 = new ListNode(2, l1_5);
        ListNode l1_3 = new ListNode(3, l1_4);
        ListNode l1_2 = new ListNode(4, l1_3);
        ListNode l1_1 = new ListNode(1, l1_2);
        partition(l1_1, 3);


        ListNode l2_2 = new ListNode(1);
        ListNode l2_1 = new ListNode(2, l2_2);
        partition(l2_1,2);
    }

    /**
     * 1->4->3->2->5->2, x=3
     * x보다 작은 수는 왼쪽에 순서대로
     * x와 같거나 큰수는 순서대로 오른쪽에
     * 1->2->2->4->3->5
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        //val:0, next:null인 ListNode 생성
        ListNode bigListNode = new ListNode();
        ListNode smallListNode = new ListNode();

        //생성된 ListNode의 포인터
        ListNode big = bigListNode;
        ListNode small = smallListNode;

        //head의 포인터
        ListNode node = head;

        while(node != null){
            //x보다 작은 val의 노드들은 smallListNode에 추가
            if(x > node.val){
                small.next = node;
                small = small.next;
            }
            //x와 같거나 큰 val의 노드들은 bigListNode에 추가
            if(x <= node.val){
                big.next = node;
                big = big.next;
            }
            node = node.next;
        }

        //두 개의 ListNode를 연결
        //bigListNode는 0부터 시작하여 0을 제외한 추가된 노드부터 연결
        small.next = bigListNode.next;
        big.next = null;

        //smallListNode는 0부터 시작하여 0을 제외한 추가된 노드만 반환
        return smallListNode.next;
    }

}