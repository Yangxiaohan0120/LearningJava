package 剑指Offer;

import org.checkerframework.checker.units.qual.N;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-27 22:45
 **/

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class BinarySearchTreetoDeque {

    Node1 head = new Node1();
    Node1 pre = new Node1();

    public Node1 treeToDoublyList(Node1 root) {
        if (root == null) return null;
        preOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void preOrder(Node1 root) {
        if (root == null) return;
        preOrder(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node1 root = new Node1(2);
        root.left = new Node1(1);
        root.right = new Node1(3);
        Node1 res = new BinarySearchTreetoDeque().treeToDoublyList(root);
    }
}
