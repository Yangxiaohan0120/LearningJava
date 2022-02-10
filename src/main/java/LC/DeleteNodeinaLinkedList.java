package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:21 PM
 */
public class DeleteNodeinaLinkedList {

    //给定一个节点删除给节点

    // 改变node的值
    public void DeleteNodeinaLinkedList(ListNode node) {

        if(node == null){
            return;
        }

        if(node.next == null){
            node = null;
        }

        node.val = node.next.val;
        node.next = node.next.next;

    }

}