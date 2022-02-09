package Alibrary.Tree;

import Alibrary.set.FileOperation;

import java.util.ArrayList;

/**
 * @ author: yxh
 * @ created: 2022-01-05 : 5:01 PM
 */
public class AVLTree <K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null)
            return;

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // LL 插入元素是左孩子(x)的左侧(z)
    // T1 < z < T2 < x < T3 < y < T4
    //         y                           x
    //        / \       y  向右旋转       /   \
    //       x   T4    ---------->     z       y
    //      / \                       / \     / \
    //     z   T3                   T1  T2   T3  T4
    //    / \
    //   T1  T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // RR 插入的元素是右孩子(x)的右侧(z)
    //T4 < y < T3 < x < T1 < z < T2
    //         y                             x
    //        / \         y 向左旋转         /   \
    //       T4  x      ----------->      y      z
    //          / \                      / \     / \
    //         T3   z                   T4  T3  T1  T2
    //             / \
    //            T1  T2
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;
        x.left = y;
        y.right = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public void add(K key, V value) {
        add(root, key, value);
    }

    public Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else node.value = value;

        // 更新当前的height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            System.out.println("Unbalance");

        //平衡维护

        // LL 插入元素是左孩子(x)的左侧(z)
        // T1 < z < T2 < x < T3 < y < T4
        //         y                           x
        //        / \       y  向右旋转       /   \
        //       x   T4    ---------->     z       y
        //      / \                       / \     / \
        //     z   T3                   T1  T2   T3  T4
        //    / \
        //   T1  T2
        // balanceFactor （y) > 1 插入左孩子L  &&   getBalanceFactor(x) >= 0 插入左侧L
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // RR 插入的元素是右孩子(x)的右侧(z)
        //T4 < y < T3 < x < T1 < z < T2
        //         y                             x
        //        / \         y 向左旋转         /   \
        //       T4  x      ----------->      y      z
        //          / \                      / \     / \
        //         T3   z                   T4  T3  T1  T2
        //             / \
        //            T1  T2
        // balanceFactor （y) < -1 插入右孩子R  &&   getBalanceFactor(x) <= 0 插入右侧R
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // LR 插入元素是左孩子(x)的右侧(z)
        // T1 < z < T2 < x < T3 < y < T4
        //         y                          y                              z
        //        / \                       /   \                          /   \
        //       x   T4       x 左旋        z     T4       y 右旋          x      y
        //      / \        --------->     /  \          ---------->     /  \    / \
        //    T1   z                     x    T3                       T1  T2  T3  T4
        //        / \                   / \
        //       T2  T3                T1  T2
        // balanceFactor （y) > 1 插入左孩子L  &&   getBalanceFactor(x) <= 0 插入右侧R
        if (balanceFactor > 1 && getBalanceFactor(node.left) <= 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL 插入的元素是右孩子(x)的左侧(z)
        //T4 < y < T3 < x < T1 < z < T2
        //         y                         y                                  z
        //       /   \         x 右旋       /   \           y 左旋             /   \
        //     T1     x     ---------->  T1     z        ---------->        y       x
        //           / \                       /  \                       /   \    /  \
        //          z   T4                    T2    x                    T1   T2  T3   T4
        //         / \                             /  \
        //        T2  T3                         T3    T4
        // balanceFactor （y) < -1 插入右孩子R  &&   getBalanceFactor(x) >= 0 插入左侧L
        if (balanceFactor < -1 && getBalanceFactor(node.right) >= 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else return getNode(node.right, key);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn's exist");

        node.value = value;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        Node retnode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retnode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retnode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retnode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retnode = leftNode;
            } else {
                Node successor = minimum(node.right);
                // removeMin (打破平衡）
//            successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retnode = successor;
            }
        }

        //删除为叶节点
        if (retnode == null)
            return null;

        retnode.height = 1 + Math.max(getHeight(retnode.left), getHeight(retnode.right));

        int balanceFactor = getBalanceFactor(retnode);
        if (Math.abs(balanceFactor) > 1)
            System.out.println("Unbalance");

        //平衡维护

        if (balanceFactor > 1 && getBalanceFactor(retnode.left) >= 0)
            return rightRotate(retnode);

        if (balanceFactor < -1 && getBalanceFactor(retnode.right) <= 0)
            return leftRotate(retnode);

        if (balanceFactor > 1 && getBalanceFactor(retnode.left) <= 0) {
            node.left = leftRotate(retnode.left);
            return rightRotate(retnode);
        }

        if (balanceFactor < -1 && getBalanceFactor(retnode.right) >= 0) {
            node.right = rightRotate(retnode.right);
            return leftRotate(retnode);
        }

        return retnode;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST: " + map.isBST());
            System.out.println("is balanced: " + map.isBalanced());
        }

        System.out.println();
    }

}