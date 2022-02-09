package Alibrary.Linear.list;

/**
 * @ author: yxh
 * @ created: 2021-12-20 : 4:21 PM
 */
class ListNodeSolution {
    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return head;
    }
}