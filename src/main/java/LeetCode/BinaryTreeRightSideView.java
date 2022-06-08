package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-12 : 6:23 PM
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            // 由于q中是一层的值，只拿最右侧值。
            // q中不会混层出现，只有一层的值
            int size = q.size();
            list.add(q.peekLast().val);

            // 记录每一层的长度
            while (size > 0) {
                // 根据长度循环，本层全部拿出来了，下一层全部填入
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                size --;
            }
        }
        return list;
    }


}