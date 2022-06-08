package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 9:09 AM
 */
public class DeleteNodeinaBST {

    // 在二分搜索树中删除节点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val < key) {
            return deleteNode(root.right, key);
        } else if (root.val > key) {
            return deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }

            TreeNode rightNode = root.right;
            while (rightNode.left != null) rightNode = rightNode.left;
            rightNode.left = root.left;
            return root.right;
        }
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode newNode = root.right;
            while(newNode.left != null) newNode = newNode.left;
            newNode.left = root.left;
            return root.right;
        }
        return root;
    }

}