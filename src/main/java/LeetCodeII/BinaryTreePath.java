package LeetCodeII;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:03 PM
 */
public class BinaryTreePath {

    // return all paths from root to leaf
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        if(root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res;
        }

        if(root.left != null){
            List<String> left = binaryTreePaths(root.left);
            for (int i = 0; i < left.size(); i++) {
                res.add(String.valueOf(root) + "->" + left.get(i));
            }
        }

        if(root.right != null){
            List<String> right = binaryTreePaths(root.right);
            for (int i = 0; i < right.size(); i++) {
                res.add(String.valueOf(root) + "->" + right.get(i));
            }
        }

        return res;
    }

}