package LC;

import Alibrary.set.LinkedList;

import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 2:15 PM
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReversedLinkedList {

    public ListNode ReversedLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }

}