package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-27 22:37
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyofComplicatedList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;

        //  “原节点 -> 新节点”
        Map<Node, Node> map = new HashMap<>();
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        // 重新指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
