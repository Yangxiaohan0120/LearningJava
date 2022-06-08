package LeetCode;

import DataStructureAndAlgorithm.set.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 9:10 AM
 */
public class LowestCommonAncestorofaBinaryTree {

    // difficult
    // LCA 问题
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }

    }

    TreeNode p, q;        // Created class level vars to save space in recursive stack i/p param
    TreeNode ans;        // Global var to save ans found by any recursive flow

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;

        contains(root, null);
        return ans;
    }

    // parentContainsNode: if any parent node has already found one of p or q, then
    // parentContainsNode var will keep the reference of that parent node
    private boolean contains(TreeNode root, TreeNode parentContainsNode) {
        // foundInRoot = true if root == p or q
        // foundInLeftSubTree = true if the left sub-tree of given root node contains one of p or q
        // foundInRightSubTree = true if the right sub-tree of given root node contains one of p or q
        boolean foundInRoot = false, foundInLeftSubTree = false, foundInRightSubTree = false;

        if (ans != null) {
            // Break all the async recursive flows in progress as soon as
            // answer is being found by some other recursive flow
            return false;
        }

        if (root == p || root == q) {
            foundInRoot = true;
        }

        if ((parentContainsNode != null) && foundInRoot) {
            ans = parentContainsNode;
            return true;
        }

        if (foundInRoot && parentContainsNode == null) {
            parentContainsNode = root;
        }

        if (root.left != null) {
            foundInLeftSubTree = contains(root.left, parentContainsNode);
        }

        if (root.right != null) {
            foundInRightSubTree = contains(root.right, parentContainsNode);
        }

        if (foundInLeftSubTree && foundInRightSubTree) {
            ans = root;
            return true;
        } else if (foundInRoot || foundInLeftSubTree || foundInRightSubTree) {
            if (foundInRoot && (foundInLeftSubTree || foundInRightSubTree)) {
                ans = root;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(root.left);
    }
}