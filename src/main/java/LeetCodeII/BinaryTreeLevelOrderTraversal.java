package LeetCodeII;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 12:48 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();

        if(root == null)return res;
        q.add(new Pair<>(root,0));

        while(q.isEmpty()){
            TreeNode cur = q.peek().getKey();
            int index = q.peek().getValue();

            q.poll();

            if(index == res.size()){
                res.add(new ArrayList<>());
            }else {
                res.get(index).add(cur.val);
            }

            if(cur.left != null)
                q.add(new Pair<>(cur.left,index + 1));
            if(cur.right != null)
                q.add(new Pair<>(cur.right,index + 1));

        }

        return res;
    }

}