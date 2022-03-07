package DataStructureAndAlgorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ author: yxh
 * @ created: 2021-12-29 : 4:55 PM
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        // Node 的多维数据维护
        public int size;
        public int height;
        public int count;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add1(root, e);
    }

    public void add1(Node node, E e) {
        if (e.compareTo(node.e) == 0) return;

        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add1(node.left, e);
        } else {
            add1(node.right, e);
        }
    }

    public void add2(E e) {
        root = add2(root, e);
    }

    //使用递归算法进行添加
    public Node add2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add2(node.right, e);
        }

        return node;
    }

    //使用非递归算法的另一种添加方式
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        Node p = root;
        while (p != null) {
            if (e.compareTo(p.e) < 0) {
                if (p.left == null) {
                    p.left = new Node(e);
                    size++;
                    return;
                }
                p = p.left;
            } else if (e.compareTo(p.e) > 0) {
                if (p.right == null) {
                    p.right = new Node(e);
                    size++;
                    return;
                }
                p = p.right;
            } else return;
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else return contains(node.left, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node p = st.pop();
            System.out.println(p.e);

            if (p.right != null)
                st.push(p.right);
            if (p.left != null)
                st.push(p.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void inOrderNR(){
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node p = st.peek();
            if (p.left != null)
                st.push(p.left);

            Node pp = st.pop();
            System.out.println(pp.e);

            if (p.right != null)
                st.push(p.right);

        }
    }

    //二分搜索树的后序遍历
    //内存释放
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);

        }
    }

    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    public Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    public Node minimumNR(Node node){
        while(node.left != null){
            node = node.left;
        }

        return node;
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    public Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    public Node maximumNR(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node) {
        if (node.left == null) {
            //将node的右侧替换为当前的node
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    public Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {   // e.compareTo(node.e) == 0

            // 找到了对应值的node
            // 待删除节点左子树为空的情况
            // 右子树代替，类似于删除Min
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            // 左子树代替，类似于删除Max
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            // removeMin删除了自己本身node
            successor.right = removeMin(node.right);
            successor.left = node.left;

            // 把原有的node删掉
            node.left = node.right = null;

            return successor;
        }

    }

    public Node remove2(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove2(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove2(node.right, e);
            return node;
        } else {   // e.compareTo(node.e) == 0

            // 找到了对应值的node
            // 待删除节点左子树为空的情况
            // 右子树代替，类似于删除Min
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            // 左子树代替，类似于删除Max
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = maximum(node.left);
            // removeMin删除了自己本身node
            successor.right = node.right;
            successor.left = removeMax(node.left);

            // 把原有的node删掉
            node.left = node.right = null;

            return successor;
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public int Depth() {
        return getDepth(root, 0);
    }

    private int getDepth(Node node, int depth) {
        if (node == null) {
            return depth;
        }

        if (node.left == null && node.right == null) {
            return depth + 1;
        }

        if (node.left != null && node.right != null) {
            return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
        } else if (node.left != null) {
            return getDepth(node.left, depth + 1);
        } else return getDepth(node.right, depth + 1);
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add2(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.inOrder();
        System.out.println();

        bst.inOrderNR();

//        System.out.println(bst.toString());
    }

}