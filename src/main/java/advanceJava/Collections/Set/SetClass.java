package advanceJava.Collections.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chris Yang
 * created 2022-03-18 22:00
 **/
public class SetClass {
    // 1) 无序
    // 2）不可有重复元素，最多包含一个null
    // 3）JDK的Set实现类有：

    // 遍历方式：
    //1,迭代器
    //2,for增强器
    //3,没有索引的方式

    public static void main(String[] args) {
        // 添加顺序和取出的顺序不一致
        // 但取出的顺序是一定的
        Set set = new HashSet();
        set.add("Jack");
        set.add("John");
        set.add("Lucy");
        set.add("Jack");
        set.add("John");

        set.add(null);
        set.add(null);

        System.out.println("set=" + set);
        HashSet_();
    }

    public static void HashSet_(){
        HashSet set = new HashSet();
        // 底层实现是一个hashMap，元素不重复，只能有一个null
        set.add("Jack");
        set.add("Jack");

        // 不能添加相同的对象或者元素
        set.add(new Dog("Lock"));
        set.add(new Dog("Lock"));

        System.out.println("set = "+ set);


        //
        set.add(new String("lalala"));
        set.add(new String("lalala")); // 不可加入

    }
}

class Dog{
    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return (name);
    }
}
