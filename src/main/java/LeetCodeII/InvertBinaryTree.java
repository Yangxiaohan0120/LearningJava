package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:50 PM
 */
public class InvertBinaryTree {

    // 轴对称反转
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if(root.left != null){
            root.left = invertTree(root.left);
        }

        if(root.right != null){
            root.right = invertTree(root.right);
        }

        return root;
    }

}