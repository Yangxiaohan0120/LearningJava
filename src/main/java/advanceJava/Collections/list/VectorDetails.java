package advanceJava.Collections.list;

import java.util.Vector;

/**
 * @author Chris Yang
 * created 2022-03-18 20:52
 **/
public class VectorDetails {
    // Vector 类的源码剖析

    // 1) Vector 的定义说明
    // extends AbstractList<E>
    //    implements List<E>, RandomAccess, Cloneable, java.io.Serializable

    // 2）Vector底层是一个对象数组：protected Object[] elementData

    // 3) Vector 是线程同步的，底层源码是有synchronized

    // 4）ArrayList效率高但是不安全，Vector更安全但是效率相对较差

    // Vector的扩容机制：第一次按照10创建，之后按照2倍进行扩容
    public static void main(String[] args) {
        Vector vector = new Vector();


        //public Vector() {
        //        this(10);
        //    }

        //public Vector(int initialCapacity) {
        //        this(initialCapacity, 0);
        //    }

        // 如果刚开始没有容量的规定，就使用10作为初始容量

        for (int i = 0; i < 10; i++) {
            vector.add(i);
            // 添加元素
            // public synchronized boolean add(E e) {
            //        modCount++;
            //        ensureCapacityHelper(elementCount + 1);
            //        elementData[elementCount++] = e;
            //        return true;
            //    }

            //private void ensureCapacityHelper(int minCapacity) {
            //        // overflow-conscious code
            //        if (minCapacity - elementData.length > 0)
            //            grow(minCapacity);
            //    }
            // 比较minCapacity

            //private void grow(int minCapacity) {
            //        // overflow-conscious code
            //        int oldCapacity = elementData.length;
            //        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
            //                                         capacityIncrement : oldCapacity);
            //        if (newCapacity - minCapacity < 0)
            //            newCapacity = minCapacity;
            //        if (newCapacity - MAX_ARRAY_SIZE > 0)
            //            newCapacity = hugeCapacity(minCapacity);
            //        elementData = Arrays.copyOf(elementData, newCapacity);
            //    }
            // 扩容时，可以根据自己自定义的capacityIncrement来进行扩容，可以使用2倍进行扩容，一般不自行设置，所以是2倍。
        }
        vector.add(100);
    }
}
