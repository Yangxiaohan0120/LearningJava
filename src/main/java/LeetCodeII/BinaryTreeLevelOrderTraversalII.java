package LeetCodeII;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:02 PM
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        List<List<Integer>> res = new LinkedList<>();
        for (int i = ls.size() - 1; i >= 0; i--) {
            res.add(ls.get(i));
        }

        return res;
    }

}