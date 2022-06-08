package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-06-01 17:23
 **/
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            return inorder(root);
        }
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root.left != null) {
            list.addAll(inorder(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorder(root.right));
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "->");
        }

        System.out.println("null");
    }
}
