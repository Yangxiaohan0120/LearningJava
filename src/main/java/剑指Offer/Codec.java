package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-07-28 16:31
 **/
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int index = 0;
        if(data.equals("[]"))return null;
        String[] datas = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[index]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        index++;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!datas[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(datas[index]));
                queue.add(node.left);
            }
            index ++;
            if(!datas[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(datas[index]));
                queue.add(node.right);
            }
            index ++;
        }
        return root;
    }

}
