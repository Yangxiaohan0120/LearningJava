package LeetCode;

/**
 * @author Chris Yang
 * created 2022-06-02 10:19
 **/
public class BinaryTreeMirror {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)return root;

        TreeNode tempNode = root.right;

        root.right = mirrorTree(root.left);
        root.left = mirrorTree(tempNode);

        return root;
    }

}
