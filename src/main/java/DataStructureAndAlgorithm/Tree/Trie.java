package DataStructureAndAlgorithm.Tree;

import java.util.TreeMap;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 3:38 PM
 */

//使用TreeMap的Trie
public class Trie {

    private class Node {
        // 当前节点是否代表单词的结尾
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
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
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void addRecursion(String word) {
        Node cur = root;
        addR(root, word, 0);
    }

    public void addR(Node node, String word, int index) {

        // 到达最后一个字母，更改isWord
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
        }

        // 未到达最后一个字母
        if (word.length() > index) {
            char addLetter = word.charAt(index);
            // 判断trie的下个节点组中是否有查询的字符,如果没有,就添加
            if (node.next.get(addLetter) == null) {
                node.next.put(addLetter, new Node());
            }
            // 基于已经存在的字符进行下个字符的递归查询
            addR(node.next.get(addLetter), word, index + 1);
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean containsRecursion(String word) {
        Node cur = root;
        return containsR(root, word, 0);
    }

    public boolean containsR(Node node, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        } else {
            return containsR(node.next.get(c), word, index + 1);
        }
    }

    public boolean search(String word){
        return search(root,word,0);
    }


    // 可以使用正则表达式的search（contains）使用递归写法
    public boolean search(Node node,String word,int index){
        if(index == word.length()){
            return true;
        }

        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            return search(node.next.get(c),word,index+1);
        }else {
            for (char nextChar : node.next.keySet()){
                if(search(node.next.get(nextChar),word,index+1))
                    return true;
            }
            return false;
        }
    }

    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}