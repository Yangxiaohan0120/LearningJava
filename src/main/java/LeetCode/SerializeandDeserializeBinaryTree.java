package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-06-15 00:50
 **/
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder res = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                res.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null");
            }
            res.append(",");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] dataList = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!dataList[index].equals("null")){
                temp.left = new TreeNode(Integer.parseInt(dataList[index]));
                queue.add(temp.left);
            }
            index++;
            if(!dataList[index].equals("null")){
                temp.right = new TreeNode(Integer.parseInt(dataList[index]));
                queue.add(temp.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String res = new SerializeandDeserializeBinaryTree().serialize(root);
        System.out.println(res);
    }
}
