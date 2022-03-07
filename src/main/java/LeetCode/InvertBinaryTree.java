package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 3:57 PM
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null)
            invertTree(root.left);

        if(root.right != null)
            invertTree(root.right);

        return root;
    }

}