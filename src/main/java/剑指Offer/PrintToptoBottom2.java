package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-07-27 21:21
 **/
public class PrintToptoBottom2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null)queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> templist = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                templist.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(templist);
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<List<Integer>> list = new PrintToptoBottom2().levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"============");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
                System.out.println("");
            }
        }
    }
}
