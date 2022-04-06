package advanceJava.Collections.Main;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Chris Yang
 * created 2022-03-18 19:49
 **/
public class ForPlus {
    public static void main(String[] args) {
        // 增强for 循环
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        for(Object book : col){
            System.out.println("Book = "+ book);
        }
        // 增强for循环也可以在数组上使用
        // 增强for的底层仍然是迭代器iterator
        // 快捷键：大写的I
    }
}
