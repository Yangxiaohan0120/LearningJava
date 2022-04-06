package advanceJava.Collections.list;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-03-18 20:03
 **/
public class listExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
//        List list = new Vector();
//        List list = new LinkedList();
        for (int i = 0; i < 12; i++) {
            list.add("Hello" + i);
        }
        System.out.println(list);

        list.add(1, "hhahah");
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6, "水浒传");


        // list For循环
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        for (Object o : list) {
            System.out.println(o);
        }

        // list 的排序
        list.clear();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
//        list.add(new Book("西游记", "吴承恩", 10));

        for (Object o : list) {
            System.out.println(o);
        }

        sort(list);

        System.out.println("======sorted======");

        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void sort(List list) {
        int listsize = list.size();
        for (int i = 0; i < listsize - 1; i++) {
            for (int j = 0; j < listsize - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
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
        return "名称：" + name + "\t\t价格:" + price + "\t\t作者：" + author;
    }


}
