package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-26 22:16
 **/
public class TheLastKthNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
