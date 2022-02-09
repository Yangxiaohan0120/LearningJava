package Alibrary.set;

/**
 * @ author: yxh
 * @ created: 2022-01-02 : 10:49 PM
 */
public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}