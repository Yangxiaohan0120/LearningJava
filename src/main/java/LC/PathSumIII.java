package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:39 PM
 */
public class PathSumIII {

    // 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int res = findPath(root, targetSum);
        res += pathSum(root.left,targetSum);
        res += pathSum(root.right,targetSum);

        return res;
    }


    private int findPath(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int res = 0;
        if (root.val == targetSum)
            res += 1;

        res += findPath(root.left, targetSum - root.val);
        res += findPath(root.right, targetSum - root.val);

        return res;
    }


}