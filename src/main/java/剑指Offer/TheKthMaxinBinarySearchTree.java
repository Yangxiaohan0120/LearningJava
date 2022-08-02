package 剑指Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-02 09:52
 **/
public class TheKthMaxinBinarySearchTree {

    Stack<TreeNode> stack = new Stack<>();

    public int kthLargest(TreeNode root, int k) {
        InOrder(root);
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = stack.pop().val;
        }
        return res;
    }

    public void InOrder(TreeNode root){
        if(root != null){
            InOrder(root.left);
            stack.push(root);
            InOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(new TheKthMaxinBinarySearchTree().kthLargest(root,3));
    }
}
