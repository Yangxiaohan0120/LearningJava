package advanceJava.CommonClass;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-03-14 22:10
 **/

public class ArraysClass {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // 1. toString
        System.out.println(Arrays.toString(arr));
        // 2. sort
        Integer[] arr1 = {1, -1, 4, 0, 99};
        Arrays.sort(arr1); // 可使用Comparator实现定制排序

        //  while (left < right) {
        //      int mid = (left + right) >>> 1;
        //      if (c.compare(pivot, a[mid]) < 0)
        //          right = mid;
        //      else
        //          left = mid + 1;
        //  }
        // 底层调用
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 如果是true则交换，o2-o1为true，o2 > o1, 交换，所以大数在前
            }
        });
        System.out.println(Arrays.toString(arr1));

        // 3. binarySearch
        System.out.println(Arrays.binarySearch(arr,200));
        // 如果没有的话，返回的是不存在的位置+1 的负数 - (low + 1)

        // 4. copyOf
        // 底层使用了System.arraycopy
        Integer[] copy = Arrays.copyOf(arr1,arr1.length);
        // 拷贝长度超出的话，后面增加null

        // 5. fill
        Integer[] num = new Integer[]{9,3,2};
        Arrays.fill(num,99);
        System.out.println(Arrays.toString(num));

        // 6.equals
        Integer[] num2 = new Integer[]{99,99,99};
        System.out.println(Arrays.equals(num,num2));

        // 7. asList
        // 运行类型为Arrays$ArrayList
        List<Integer> list = Arrays.asList(num);
        System.out.println(list);
        System.out.println("list的运行类型" + list.getClass());
    }

    // 使用冒泡完成排序
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //结合冒泡定制排序
    public static void bubbleSort02(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 由compare方法中的定制方法来决定
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class ArrayTest{
    class Book{
        public String name;
        public int price;

        public Book(String name,int price){
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString(){
            return name+":"+price;
        }
    }

    public void test() {
        Book[] books = new Book[4];
        books[0] = new Book("Pride and Prejudice",100);
        books[1] = new Book("Withering Heights",90);
        books[2] = new Book("Jane Eyre",20);
        books[3] = new Book("Emma",50);

        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.price-o2.price;
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.price-o1.price;
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.name.compareTo(o1.name);
            }
        });
        System.out.println(Arrays.toString(books));
    }

    public static void main(String[] args) {
        new ArrayTest().test();
    }
}