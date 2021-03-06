package DataStructureAndAlgorithm.Tree;

/**
 * 使用array的Trie
 *
 * @ author: yxh
 * @ created: 2022-01-04 : 4:56 PM
 */


// 使用数组实现 Trie
public class Trie3 {

    private class Node {
        public boolean isWord;
        public Node[] next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie3() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }

        return true;
    }

}