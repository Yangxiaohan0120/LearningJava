package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:08 PM
 */
public class SwaoNodesinPairs {

    public ListNode SwaoNodesinPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode p = dummyhead;
        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;

            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        return dummyhead.next;

    }

}