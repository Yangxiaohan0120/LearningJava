package LC;

import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:15 PM
 */
public class ReverseNodesinKGroup {

    public ListNode ReverseNodesinKGroup(ListNode head,int k) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode p = dummyhead;
        while(p.next != null && p.next.next != null){
            ListNode[] node = new ListNode[k];
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