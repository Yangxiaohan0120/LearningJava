package Alibrary.map;

import Alibrary.Tree.AVLTree;

/**
 * @ author: yxh
 * @ created: 2022-01-07 : 9:37 AM
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        avl = new AVLTree();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }
}