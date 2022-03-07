package DataStructureAndAlgorithm.Heap;

/**
 * @ author: yxh
 * @ created: 2021-12-20 : 9:39 AM
 */

/*
    队列需要实现的功能（interface）
 */

public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
