package DataStructureAndAlgorithm.Heap;

/**
 * @ author: yxh
 * @ created: 2021-12-20 : 9:39 AM
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
