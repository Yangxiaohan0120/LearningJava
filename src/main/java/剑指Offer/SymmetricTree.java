package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-27 19:13
 **/
public class SymmetricTree {

    List<TreeNode> list = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return isSymmetric(L.left, R.right) && isSymmetric(L.right, R.left);
    }

    public void Inorder(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        new SymmetricTree().isSymmetric(root);
    }
}
