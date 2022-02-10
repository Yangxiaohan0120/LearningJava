package LC;

import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 3:43 PM
 */
public class RemoveLinkedListElements {

    public ListNode RemoveLinkedListElements(ListNode head,int val) {

        while(head!= null && head.val == val){
            head.next = head.next.next;
        }

        if(head == null){
            return null;
        }

        ListNode cur = head;

        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode RemoveLinkedListElements2(ListNode head,int val) {

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode cur = dummyhead;

        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return dummyhead.next;
    }

}