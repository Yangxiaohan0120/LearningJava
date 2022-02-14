package LC;

import java.util.LinkedList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:27 PM
 */
public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new LinkedList<>();

        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }

        if(root.left != null) {
            List<String> left = binaryTreePaths(root.left);
            for (int i = 0; i < left.size(); i++) {
                res.add(String.valueOf(root.left.val) + "->" + left.get(i));
            }
        }

        if(root.right != null) {
            List<String> right = binaryTreePaths(root.right);
            for (int i = 0; i < right.size(); i++) {
                res.add(String.valueOf(root.right.val) + "->" + right.get(i));
            }
        }

        return res;
    }

}