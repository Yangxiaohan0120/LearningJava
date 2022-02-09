package Alibrary.Linear.stack;

/**
 * @ author: yxh
 * @ created: 2021-12-19 : 5:02 PM
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}