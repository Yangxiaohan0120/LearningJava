package advanceJava.Collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-03-18 19:55
 **/
public class listClass {
    public static void main(String[] args) {
        // list集合中元素顺序有序（添加和取出一致），可重复
        List list = new ArrayList<>();
        list.add("Jack");
        list.add("Tom");
        list.add("Jack");
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("张三");
        // list中的每个元素都有对应的顺序索引，可以按照索引取出
        list.get(0);
        // list 的主要方法：
        // add()
        list.add("Rose");
        // boolean addAll()
        list.addAll(list1);
        System.out.println(list);
        // get()
        System.out.println(list.get(0));
        // indexOf()
        System.out.println(list.indexOf("Jack"));
        // lastIndexOf
        System.out.println(list.lastIndexOf("Jack"));
        // remove
        list.remove("Rose");
        System.out.println(list);
        // removeAll
        list.removeAll(list1);
        System.out.println(list);
        // set
        list.set(0,"David");
        System.out.println(list);
        // subList
        System.out.println(list.subList(0,2));
    }
}
