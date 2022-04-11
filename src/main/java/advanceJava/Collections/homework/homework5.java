package advanceJava.Collections.homework;

import java.util.TreeSet;

/**
 * @author Chris Yang
 * created 2022-04-11 13:48
 **/
public class homework5 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //分析源码
        //add 方法，因为 TreeSet() 构造器没有传入Comparator接口的匿名内部类
        //所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //即 把 Perosn转成 Comparable类型
        treeSet.add(new Person());//ClassCastException.
        treeSet.add(new Person());//ClassCastException.
        treeSet.add(new Person());//ClassCastException.
        treeSet.add(new Person());//ClassCastException.
        treeSet.add(new Person());//ClassCastException.

        System.out.println(treeSet);
    }
}

class Person implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}