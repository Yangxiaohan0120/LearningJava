package advanceJava.Collections.list;

import java.util.LinkedList;

/**
 * @author Chris Yang
 * created 2022-03-18 21:07
 **/
public class LinkedListDetails {
    // LinkedList 的底层结构：

    //1）LinkedList底层实现了双向链表和双向队列的特点
    //2）可以添加任意元素（元素可重复），包括null
    //3）线程不安全，没有实现同步

    //extends AbstractSequentialList<E>
    //    implements List<E>, Deque<E>, Cloneable, java.io.Serializable

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //public LinkedList() {
        //    }
        //    /**
        //     * Pointer to first node.
        //     * Invariant: (first == null && last == null) ||
        //     *            (first.prev == null && first.item != null)
        //     */
        //    transient Node<E> first;
        //
        //    /**
        //     * Pointer to last node.
        //     * Invariant: (first == null && last == null) ||
        //     *            (last.next == null && last.item != null)
        //     */
        //    transient Node<E> last;

        linkedList.add(1);
        //public boolean add(E e) {
        //        linkLast(e);
        //        return true;
        //    }
        // linkLast() 在最后面添加新的元素

        //void linkLast(E e) {
        //        final Node<E> l = last;
        //        final Node<E> newNode = new Node<>(l, e, null);
        //        last = newNode;
        //        if (l == null)
        //            first = newNode;
        //        else
        //            l.next = newNode;
        //        size++;
        //        modCount++;
        //    }
        // l = last
        // last   <-- newNode -->  null
        // l   <--  last  --> null
        // 如果l是空： null  <-- first | last --> null
        // 如果不是  l --> <-- last --> null

        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);

        linkedList.remove();
        // ==> removeFirst
        //public E removeFirst() {
        //        final Node<E> f = first;
        //        if (f == null)
        //            throw new NoSuchElementException();
        //        return unlinkFirst(f);
        //    }
        // 如果链表为空抛出异常

        //private E unlinkFirst(Node<E> f) {
        //        // assert f == first && f != null;
        //        final E element = f.item;
        //        final Node<E> next = f.next;
        //        f.item = null; // 值为空
        //        f.next = null; // help GC （GC的算法会认为这个f为一个垃圾对象进行回收）
        //        first = next;  // 指针向下移动
        //        if (next == null)
        //            last = null; // 如果只有一个元素，next==null，将last也进行修改
        //        else
        //            next.prev = null;
        //        size--;
        //        modCount++;
        //        return element;
        //    }
        //

        linkedList.remove(1);
        // 删除index对应的元素
        //public E remove(int index) {
        //        checkElementIndex(index);
        //        return unlink(node(index));
        //    }
        // 首先进行check 查看是否有对应的元素

        //private void checkElementIndex(int index) {
        //        if (!isElementIndex(index))
        //            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        //    }

        //private boolean isElementIndex(int index) {
        //        return index >= 0 && index < size;
        //    }
        // 根据index的值，来进行判断

        //E unlink(Node<E> x) {
        //        // assert x != null;
        //        final E element = x.item;
        //        final Node<E> next = x.next;
        //        final Node<E> prev = x.prev;
        //
        //        if (prev == null) { // 判断Node x 为first
        //            first = next;
        //        } else {
        //            prev.next = next;
        //            x.prev = null;
        //        }
        //
        //        if (next == null) { // 判断Node x 为last
        //            last = prev;
        //        } else {
        //            next.prev = prev;
        //            x.next = null;
        //        }
        //
        //        x.item = null; // 直接使值消除？
        //        size--;
        //        modCount++;
        //        return element;
        //    }
        // 按照Node来进行删除（和removeFirst有一定的类似）
    }
}
