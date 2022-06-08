package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 4:38 PM
 */
public class SumRoottoLeafNumbers {

    int sum;

    // 所有从根节点到叶节点路径所表示数字的和
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        // 左边的树
        sum(root.left,root.val);
        // 右边的树
        sum(root.right,root.val);

        return sum;
    }

    public void sum(TreeNode root, int value) {
        // 回溯上一个节点的值 value，如果这个节点是空的就直接返回
        if (root == null) return;
        // 如果不空则原来的值翻10倍，加上这个值
        value = value * 10 + root.val;
        // 如果到终点，就在sum 上加上value
        if (root.left == null && root.right == null) {
            sum += value;
        }
        // 走左边的树
        sum(root.left, value);
        // 走右边的树
        sum(root.right, value);
    }

}