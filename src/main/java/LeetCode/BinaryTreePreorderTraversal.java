package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-02 10:14
 **/
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        res.add(root.val);
        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }

        return res;
    }
}
