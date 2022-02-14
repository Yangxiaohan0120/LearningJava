package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:11 PM
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;

        if(root.left == null && root.right == null){
            return targetSum == 0;
        }

        if(hasPathSum(root.left,targetSum - root.val))
            return true;

        if(hasPathSum(root.right,targetSum - root.val))
            return true;

        return false;
    }

}