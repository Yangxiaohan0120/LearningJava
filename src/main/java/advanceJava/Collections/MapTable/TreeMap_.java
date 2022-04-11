package advanceJava.Collections.MapTable;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Chris Yang
 * created 2022-04-11 11:44
 **/
public class TreeMap_ {
    public static void main(String[] args) {

        //使用默认的构造器，创建TreeMap, 是无序的(也没有排序)
        /*
            老韩要求：按照传入的 k(String) 的大小进行排序
         */
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的 k(String) 的大小进行排序
                //按照K(String) 的长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了
        treeMap.put("Rose", "肉丝");// 只在乎comparator中写的内容，比如说只在乎String的长度，但是不需要具体内容，jack rose都是4个，值不一样就进行了更改

        System.out.println("treemap=" + treeMap);

        TreeMap<Integer,String> intmap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt(String.valueOf(o1)) - Integer.parseInt(String.valueOf(o2));
            }
        });

        intmap.put(4, "斯密斯");
        intmap.put(3, "克瑞斯提诺");
        intmap.put(1, "杰克");
        intmap.put(2, "汤姆");
        intmap.put(1, "韩顺平");

        System.out.println("intmap=" + intmap);

        /*

            老韩解读源码：
            1. 构造器. 把传入的实现了 Comparator接口的匿名内部类(对象)，传给给TreeMap的comparator
             public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            2. 调用put方法
            2.1 第一次添加, 把k-v 封装到 Entry对象，放入root
            Entry<K,V> t = root;
            if (t == null) {
                compare(key, key); // type (and possibly null) check

                root = new Entry<>(key, value, null);
                size = 1;
                modCount++;
                return null;
            }
            2.2 以后添加
            Comparator<? super K> cpr = comparator;
            if (cpr != null) {
                do { //遍历所有的key , 给当前key找到适当位置
                    parent = t;
                    cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else  //如果遍历过程中，发现准备添加Key 和当前已有的Key 相等，就不添加
                        return t.setValue(value);
                } while (t != null);
            }
         */

    }
}

