package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-25 10:13
 **/
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummyHead = pre;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                ListNode next = cur.next;
                pre = cur;
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(9);
        node.next.next.next = new ListNode(1);
        ListNode res = new DeleteNode().deleteNode(node,5);
        while(res != null){
            System.out.print(res.val + " ->");
            res = res.next;
        }
        System.out.println("null");
    }
}
