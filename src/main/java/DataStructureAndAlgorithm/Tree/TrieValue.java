package DataStructureAndAlgorithm.Tree;

import java.util.TreeMap;

/**
 * @ author: yxh
 * @ created: 2022-01-20 : 10:04 AM
 */

// 带有Value值的Trie == MapSum
public class TrieValue {
    private class Node {
        // 当前节点是否代表单词的结尾
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public void insert(String word, int val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {

        int res = node.value;
        for (char c : node.next.keySet())
            res += sum(node.next.get(c));

        return res;
    }
}