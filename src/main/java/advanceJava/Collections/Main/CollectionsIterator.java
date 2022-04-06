package advanceJava.Collections.Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Chris Yang
 * created 2022-03-18 19:38
 **/
public class CollectionsIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));


        //System.out.println("col=" + col);
        //现在老师希望能够遍历 col集合
        //1. 先得到 col 对应的 迭代器
        Iterator iterator = col.iterator();
        //2. 使用while进行遍历
        while(iterator.hasNext()){ // itit快捷键 ==> while + iterator
//            Book next = (Book) iterator.next();
            Object next = iterator.next(); // 编译类型为Object 运行类型为 Book
            System.out.println(next.toString());
        }
        // command + j 显示所有的快捷键
        // 3. 退出while后，iterator指向最后一个元素
//        iterator.next() // NoSuchElementException
        iterator = col.iterator(); // 重置迭代器

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }


}