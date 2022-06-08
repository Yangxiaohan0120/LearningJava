package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ author: yxh
 * @ created: 2022-02-12 : 6:03 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new LinkedList<>();
        if (root == null)
            return ls;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            TreeNode node = q.peek().getKey();
            int level = q.peek().getValue();

            q.poll();

            if (level == ls.size())
                ls.add(new LinkedList<>());
            ls.get(level).add(node.val);

            if (node.left != null)
                q.add(new Pair<>(node.left, level + 1));
            if (node.right != null)
                q.add(new Pair<>(node.right, level + 1));
        }

        return ls;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()){
            TreeNode node = queue.peek().getKey();
            int level = queue.peek().getValue();

            if(level == res.size()){
                res.add(new ArrayList<>());
            }else {
                res.get(level).add(node.val);
            }

            if(node.left != null){
                queue.add(new Pair<>(node.left,level + 1));
            }
            if(node.right != null){
                queue.add(new Pair<>(node.right,level + 1));
            }
        }

        return res;
    }
}