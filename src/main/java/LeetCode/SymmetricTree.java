package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:03 PM
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }else return isSym(root.left,root.right);

    }

    public boolean isSym(TreeNode p,TreeNode q){
        if(p == null && q == null)return true;
        if(p == null || q == null)return false;
        return (p.val == q.val) && isSym(p.left,q.right) && isSym(p.right,q.left);
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new LinkedList<>();

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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(3);


        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "->");
        }

        System.out.println("null");

        System.out.println(new SymmetricTree().isSymmetric(root));

    }

}