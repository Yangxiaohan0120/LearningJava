package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 10:29 AM
 */
public class PathSumIII {

    // 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;

        if(root.val == targetSum){
            return 1;
        }

        int res = findPath(root,targetSum); // 包含
        res += pathSum(root.left,targetSum); // 不包含
        res += pathSum(root.right,targetSum);

        return res;

    }

    private int findPath(TreeNode root,int sum){
        if(root == null)return 0;

        int res = 0;
        if (root.val == sum) // 随时相等就+1；
            res += 1;

        res += findPath(root,sum-root.val);
        res += findPath(root,sum-root.val);

        return res;
    }

}