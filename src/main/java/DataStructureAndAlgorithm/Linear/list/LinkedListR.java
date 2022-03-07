package DataStructureAndAlgorithm.Linear.list;

import javafx.util.Pair;

/**
 * linkedlist using recursion
 *
 * @ author: yxh
 * @ created: 2021-12-21 : 4:36 PM
 */
public class LinkedListR<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
    }

    public LinkedListR(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Argument is empty");

        Node nodetemp = new Node(arr[0],null);
        Node node = nodetemp;
        for (int i = 1; i < arr.length; i++) {
            node.next = new Node(arr[i],null);
            node = node.next;
        }

        head = nodetemp;
        return;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        head = add(head, index, e);
        size++;
    }

    private Node add(Node node, int index, E e) {
        if (index == 0)
            return new Node(e, node);

        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0)
            return (E) node.e;
        return (E) get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Update failed. Illegal index.");

        head = set(head, index, e);
    }

    private Node set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return node;
        }
        return set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair remove(Node node, int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        if (index == 0)
            return new Pair<>(node.next, node.e);
        Pair<Node, E> res = remove(node.next, index - 1);

        node.next = res.getKey();//连接到下一个节点（key储存节点，value储存删除的值，如果这个位置不删除就向后更新res的值）
        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        node.next = removeElement(node.next, e);

        if (node.e.equals(e)) {
            size--;
            return node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}