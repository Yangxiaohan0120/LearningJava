package LeetCode;

/**
 * @author Chris Yang
 * created 2022-06-14 23:46
 **/
public class BinaryTreeMaximumPathSum {

    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxRoot(root);
        return maxPathSum;

    }

    public int maxRoot(TreeNode node){
        if (node == null) {
            return 0;
        }

        int left = Math.max(0,maxRoot(node.left));
        int right = Math.max(0,maxRoot(node.right));
        maxPathSum = Math.max(maxPathSum,node.val + left + right);

        return Math.max(left,right) + node.val;
    }

    public int maxPathSum1(TreeNode root) {
        maxPath(root);
        return maxPathSum;
    }

    public int maxPath(TreeNode node){
        if (node == null) {
            return 0;
        }

        int left = maxPath(node.left);
        int right = maxPath(node.right);
        int m1 = Math.max(Math.max(left+node.val,right+node.val),node.val);
        int m2 = Math.max(m1,left+right+node.val);
        maxPathSum = Math.max(maxPathSum,m2);

        return m1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int res = new BinaryTreeMaximumPathSum().maxPathSum(root);
        System.out.println(res);
    }

}
