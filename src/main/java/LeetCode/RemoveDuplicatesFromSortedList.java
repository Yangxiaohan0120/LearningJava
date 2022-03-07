package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 3:20 PM
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode RemoveDuplicatesFromSortedList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == pre.val){
                cur = cur.next;
            }else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }

        pre.next = cur;
        return head;
    }

}