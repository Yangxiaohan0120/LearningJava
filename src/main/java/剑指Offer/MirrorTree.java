package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-27 22:26
 **/
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)return null;
        TreeNode tmp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(tmp);
        return root;
    }
}
