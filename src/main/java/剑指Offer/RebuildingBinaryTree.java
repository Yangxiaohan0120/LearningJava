package 剑指Offer;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Chris Yang
 * created 2022-07-22 13:41
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RebuildingBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));

        return root;
    }
}
