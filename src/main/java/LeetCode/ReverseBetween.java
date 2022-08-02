package LeetCode;

/**
 * @author Chris Yang
 * created 2022-07-30 21:31
 **/
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = null;
        ListNode cur = head;
        int i = 1;
        for (; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        ListNode left1 = pre;
        ListNode left2 = cur;

        ListNode next = null;
        for (; i <= n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode right1 = pre;
        ListNode right2 = cur;

        left1.next = right1;
        left2.next = right2;

        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new ReverseBetween().reverseBetween(head, 2, 4);

    }
}
