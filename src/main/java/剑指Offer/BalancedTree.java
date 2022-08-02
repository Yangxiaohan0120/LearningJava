package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-02 10:18
 **/
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
