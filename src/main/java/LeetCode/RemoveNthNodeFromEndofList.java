package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:28 PM
 */
public class RemoveNthNodeFromEndofList {

    // 删除倒数第N个节点
    public ListNode RemoveNthNodeFromEndofList(ListNode head,int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public ListNode RemoveNthNodeFromEndofList2(ListNode head,int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n+1; i++) {
            if(q != null){
                q = q.next;
            }
        }

        while(q != null){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

}