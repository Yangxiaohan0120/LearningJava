package advanceJava.Collections.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Chris Yang
 * created 2022-03-29 15:22
 **/
public class LinkedHashSetStructure {
    public static void main(String[] args) {
        // public LinkedHashMap(int initialCapacity, float loadFactor) {
        //        super(initialCapacity, loadFactor);
        //        accessOrder = false;
        //    }
        // 使用了LinkedHashMap作为底层的数据结构
        // 维护的是数组 + 双向链表
        // 根据hashCode值决定存储的位置，使用链表维护元素的次序
        // 不允许添加重复元素

        LinkedHashSet set = new LinkedHashSet();
        set.add("John");
        set.add("Jack");
        set.add("Rose");
        for ( Object o : set){
            System.out.println(o);
        }

        System.out.println("===================");

        HashSet set1 = new HashSet();
        set1.add("John");
        set1.add("Jack");
        set1.add("Rose");
        for ( Object o : set1){
            System.out.println(o);
        }


        HashSet set3 = new HashSet();
        set3.add(new String("AA"));
        set3.add(456);
        set3.add(456);
        set3.add(123);
        set3.add("hsp");

        // 底层代码解读
        LinkedHashSet set2 = new LinkedHashSet();
        set2.add(new String("AA"));
        set2.add(456);
        set2.add(456);
        set2.add(123);
        set2.add("hsp");


        //static class Entry<K,V> extends HashMap.Node<K,V> {
        //    Entry<K,V> before, after;
        //    Entry(int hash, K key, V value, Node<K,V> next) {
        //        super(hash, key, value, next);
        //    }
        //}
        // LinkedHashSet 存储的是Entry 继承自Node




        //void afterNodeInsertion(boolean evict) { // possibly remove eldest
        //        LinkedHashMap.Entry<K,V> first;
        //        if (evict && (first = head) != null && removeEldestEntry(first)) {
        //            K key = first.key;
        //            removeNode(hash(key), key, null, false, true);
        //        }
        //}
        // 加入新元素之后：
    }
}
