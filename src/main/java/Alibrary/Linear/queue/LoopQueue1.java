package Alibrary.Linear.queue;

/**
 * @ author: yxh
 * @ decription queue using size without wasting space
 * @ created: 2021-12-20 : 10:39 AM
 */
public class LoopQueue1<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue1(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue1() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    //判断是否为空直接返回size
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    //判断是否为空直接返回size
    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty.");
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        //front 和 tail 会相等，因此改写循环
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if ((i + 1 + front) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}