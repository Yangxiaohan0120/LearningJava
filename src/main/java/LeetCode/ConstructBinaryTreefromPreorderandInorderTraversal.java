package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-06-02 10:34
 **/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> q = new LinkedList<>();
        for (int ele : preorder)
            q.offer(ele);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int start = 0;
        int end = preorder.length - 1;
        return recursion(q, map, start, end);

    }

    public TreeNode recursion(Queue<Integer> q, HashMap<Integer,Integer> mp, int start, int end) {
        if(start > end)
            return null;
        TreeNode root = new TreeNode(q.poll());
        int index = mp.get(root.val);
        root.left = recursion(q, mp, start, index-1);
        root.right = recursion(q, mp, index+1, end);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};

        TreeNode root = new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder,inorder);

    }
}
