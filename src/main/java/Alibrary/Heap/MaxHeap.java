package Alibrary.Heap;

import Alibrary.Linear.array.Array;
import Alibrary.map.Map;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-01-03 : 11:24 PM
 */
public class MaxHeap<E extends Comparable<E>> {

    // 可以不用考虑容量改变的问题
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // heapify 将任意数组变成最大堆
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
                siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax whean heap is empty");
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    public void siftDown(int k) {
        // 保证左孩子不越界
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            // 右孩子也不能越界，右孩子大，如果右边越界或者右边小，j都不用++；
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;

            // j 是两个孩子的大值索引
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j; // 置换一层后，将继续向下交换，直到变为叶子节点。
        }
    }

    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;

    }

}