package Alibrary.Linear.array;

import Alibrary.Linear.queue.Queue;

/**
 * @ author: yxh
 * @ created: 2021-12-20 : 9:41 AM
 */
public class ArrayQueue<E> implements Queue<E> {

    DynamicArray<E> array = new DynamicArray<E>();

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}