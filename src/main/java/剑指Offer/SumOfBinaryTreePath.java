package 剑指Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-28 11:17
 **/
public class SumOfBinaryTreePath {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, int target){
        if(node == null)return;
        list.add(node.val);
        target -= node.val;
        if(target == 0 && node.left == null && node.right == null){
            res.add(new LinkedList<>(list));
        }
        dfs(node.left,target);
        dfs(node.right,target);
        list.removeLast();
    }
}
