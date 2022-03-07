package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 10:26 AM
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;

        if(root.right == null && root.left == null){
            return targetSum == 0;
        }

        if(hasPathSum(root.left,targetSum-root.val)){
            return true;
        }

        if(hasPathSum(root.right,targetSum-root.val)){
            return true;
        }

        return false;
    }

}