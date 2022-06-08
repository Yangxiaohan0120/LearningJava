package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 2:29 PM
 */
public class ReversedLinkedListII {


    //翻转局部的链表

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode L1 = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            L1 = L1.next;
        }

        ListNode tail = L1.next;
        ListNode cur = tail;
        ListNode next = cur.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next1 = next.next;
            next.next = cur;
            cur = next;
            next = next1;
        }

        L1.next = cur;
        tail.next = next;

        return dummyHead.next;
    }

}