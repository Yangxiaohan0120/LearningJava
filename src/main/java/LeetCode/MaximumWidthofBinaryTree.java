package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-06-14 17:07
 **/
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        int ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek().getKey();
                int index = queue.peek().getValue();

                min = (int)Math.min(index,min);
                max = (int)Math.max(index,max);

                queue.poll();

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, index * 2 + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, index * 2 + 2));
                }
            }

            ans = (int)Math.max(max-min+1,ans);

        }

        return ans;
    }
}
