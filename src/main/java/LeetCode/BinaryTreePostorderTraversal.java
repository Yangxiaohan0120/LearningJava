package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-02 11:12
 **/
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)return list;
        if(root.left != null){
            list.addAll(postorderTraversal(root.left));
        }
        if(root.right != null){
            list.addAll(postorderTraversal(root.right));
        }
        list.add(root.val);

        return list;
    }
}
