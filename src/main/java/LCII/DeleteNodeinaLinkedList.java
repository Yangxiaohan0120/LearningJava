package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:04 PM
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        // 只考虑了这个node

        if(node == null)return;

        if(node.next == null){
            node = null;
        }

        node.val = node.next.val;
        node.next = node.next.next;

    }

}