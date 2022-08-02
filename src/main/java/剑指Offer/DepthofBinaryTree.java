package 剑指Offer;

import DataStructureAndAlgorithm.Linear.array.Array;
import advanceJava.Collections.list.ArrayListDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-08-02 10:11
 **/
public class DepthofBinaryTree {


    List<Integer> list = new ArrayList<>();

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }

    public void dfs(TreeNode root, int index) {
        if (root == null) {
            list.add(index);
        } else {
            dfs(root.left, index + 1);
            dfs(root.right, index + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(new DepthofBinaryTree().maxDepth(root));
    }
}
