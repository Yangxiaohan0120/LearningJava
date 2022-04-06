package advanceJava.Collections.list;

import java.util.ArrayList;

/**
 * @author Chris Yang
 * created 2022-03-18 20:21
 **/
public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("Jack");
        arrayList.add(null);


        // ArrayList 是线程不安全的
//        public boolean add(E e) {
//            ensureCapacityInternal(size + 1);  // Increments modCount!!
//            elementData[size++] = e;
//            return true;
//        }
        // 并没有使用 synchronized进行加锁保证线程的安全性
        System.out.println(arrayList);
    }
}
