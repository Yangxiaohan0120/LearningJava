package 剑指Offer;


/**
 * @author Chris Yang
 * created 2022-07-27 17:13
 **/
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        return dummyHead.next;
    }
}
