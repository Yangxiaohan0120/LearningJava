package advanceJava.Collections.Set;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-03-27 16:31
 **/

// HashSet 数据结构的模拟（HashSet的底层就是HashMap）

public class HashSetStructure {
    public static void main(String[] args) {

        // 1.创建数组，类型为Node[]
        Node[] table = new Node[16];
        System.out.println("table = " + table);

        // 2.创建结点
        Node john = new Node("John", null);

        table[2] = john;
        System.out.println("table = " + table);

        Node jack = new Node("Jack", null);
        john.next = jack;
        System.out.println("table = " + table);


        // 3.源码解读
        HashSet set1 = new HashSet();
        set1.add("Jack");
        set1.add("Rose");
        set1.add("Jack");
        System.out.println("set1 = " + set1);

        // 4.扩容机制，链表与树结构的创立
        HashSet set2 = new HashSet();
        for (int i = 0; i < 100; i++) {
            set2.add(i);
        }

        // 定义hashCode使得可以在同一个位置上存储
        // 链表的机制
        HashSet set3 = new HashSet();
        for (int i = 0; i < 7; i++) {
            set3.add(new A(i));
        }

        // 红黑树的机制
        HashSet set4 = new HashSet();
        for (int i = 0; i < 12; i++) {
            set4.add(new B(i));
        }


        //构造器
//        public HashSet() {
//            map = new HashMap<>();
//        }

        //添加元素
//        public boolean add(E e) {
//            return map.put(e, PRESENT)==null;
//        }

//        public V put(K key, V value) {
//            return putVal(hash(key), key, value, false, true);
//        }

        //hash计算
//        static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        }

        //存储数据
        //transient Node<K,V>[] table;
//        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        Node<K,V>[] tab; Node<K,V> p; int n, i; // 辅助变量
        // 空数组直接创建新的table，初始容量为16
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
        // 对应位置是否有数值
//        if ((p = tab[i = (n - 1) & hash]) == null)
        //hash 计算散列[(n-1)& hash] 直接创建新的Node放到对应的位置上
        //(n-1)最后一位的index 绝对是 1111……  （n-1）& hash = hash（n-1二进制的位数）（确定位数）多出来的位数变为0
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            Node<K,V> e; K k;
                // hash值相同，且key值也相同（同一个值）
                // hash 代表是否是一个对象，key代表值是否相同
//            if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
                // hash值相同但是key值不同
                // 树结构添加新元素，判断p是不是红黑树
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
                // 链结构添加新元素
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
                            // TREEIFY_THRESHOLD = 8
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            // 如果链长大于了thre，将链表改成红黑树的形式
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict); // 空方法，使得子类可以进行实现的方法。
//        return null; // 返回空，如果查询到，则返回值。说明添加成功了。
//    }



    }
}

class Node { // 结点，存放数据，并指向下一个节点，形成链表
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

}

class A{
    private int n;

    public A(int n){
        this.n = n;
    }

    @Override
    public int hashCode(){
        return 100;
    }
}

class B{
    private int n;

    public B(int n){
        this.n = n;
    }

    @Override
    public int hashCode(){
        return 200;
    }
}
