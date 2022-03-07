package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 9:04 AM
 */
public class LowestCommonAncesterofaBinarySearchTree {

    // p,q的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }

}