package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:10 PM
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int depth1 = depth(root.left);
        int depth2 = depth(root.right);

        boolean res = true;

        if(Math.abs(depth1 - depth2) > 1){
            res = false;
        }else {
            res = res && isBalanced(root.left) && isBalanced(root.right);
        }

        return res;
    }

    public int depth(TreeNode root){
        if (root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        int depth = Math.max(leftDepth,rightDepth) + 1;

        return depth;
    }

}