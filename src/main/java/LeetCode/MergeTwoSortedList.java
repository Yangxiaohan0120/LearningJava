package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-10 11:50
 **/
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                node.next = head1;
                head1 = head1.next;
            }else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }

        while(head1 != null){
            node.next = head1;
            head1 = head1.next;
            node = node.next;
        }

        while(head2 != null){
            node.next = head1;
            head2 = head2.next;
            node = node.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
