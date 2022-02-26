package LCII;


import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 12:55 PM
 */
public class RemoveLinkedListElements {

    public ListNode RemoveLinkedListElements(ListNode head, int val) {
        if(head == null)return head;

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == val){
                cur = cur.next;
            }else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }

        pre.next = cur;
        return dummyhead.next;
    }

}