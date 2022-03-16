package advanceJava.CommonClass;


/**
 * @author Chris Yang
 * created 2022-03-14 19:42
 **/

//  String 用于保存字符串，一组字符序列
//  双引号标识
//  Unicode字符编码（一个字符占两个字节）
//  String常用的构造方法


// String 对象的创建方式
// 直接赋值： String s = "hsp";
// 调用构造器： String s2 = new String("hsp");

// 方式1： 先从常量池查看是否有"hsp"数据空间，如果有直接指向。如果没有则重新创建后指向。s最终指向的是常量池(方法区)的空间地址。
// 方式2： 现在堆中创建空间，维护了value属性，指向常量池的hsp空间。如果没有"hsp"重新创建，如果有，直接通过value指向。最终指向的是堆中的空间地址。
// 方式1： s -> 0X99 (栈） -----> "hsp" 0X99 （方法区）
// 方式2： s2 -> 0X06 （栈）-----> value 0X06 （堆）------> "hsp" 0X99 （方法区）

public class StringClass01 {
    public static void main(String[] args) {
        // 1.
        // 实现的接口java.io.Serializable, Comparable<String>, CharSequence
        // Serializable ： 可以串行化，就是可以在网络上传输
        // final 修饰，不可被继承。
        // 有private final char value[] 属性，不可修改（value地址不可修改，并非值不可修改）
        String name = "Jack";

        final char[] value = {'a','b','c'};
        char[] t = {'o','b','k'};
//        value = t; //不可以指向新的地址

        test1();
        test2();
        test3();
        test4();
    }

    public static void test1(){
        String a = "abc";
        String b = "abc";
        System.out.println(a.equals(b)); // 判断值是否相等
        System.out.println(a == b); // 判断地址是否相同
        String c = new String("abc");
        System.out.println(a.equals(c));
        System.out.println(a == c);
    }

    public static void test2(){
        String a = "hsp"; // a --> 常量池
        String b = new String("hsp"); // b --> 堆
        System.out.println(a.equals(b)); // true
        System.out.println(a == b); // false
        System.out.println(a == b.intern()); // true
        // intern
        // if the pool already contains a string equal to this String object as determined
        // by the equals(Object) method, then the string from the pool is returned.
        // Otherwise, this String object is added to the pool and a reference to
        // this String object is returned.

        // intern方法：如果常量池中已经包含一个等于此String对象的字符串，则返回池中的字符串。
        // 否则，将此String对象添加到池中，并返回String对象的引用。
        // intern == 常量池的引用
        System.out.println(b == b.intern()); // false
    }

    public static void test3(){
        String s1 = "hspedu";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");

        System.out.println(s2 == s3); // 常量池和堆中的对象 false
        System.out.println(s2 == s4); // 常量池的地址 true
        System.out.println(s2.equals(s3)); // 比较值是否相同 true
        System.out.println(s1 == s2); // false
    }

    public static void test4(){
        Person1 p1 = new Person1();
        p1.name = "hspedu";
        Person1 p2 = new Person1();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));// true
        System.out.println(p1.name == p2.name); // false --> true
        System.out.println(p1.name == "hspedu"); // false --> true

        // p1(栈） -->  name1 (堆) --> "hspedu" （常量池）
        // p2(栈） -->  name2 (堆) --> "hspedu" （常量池）

        // name 的指向地址是一样的，所以2 为true
        // p1.name 和 "hspedu" 也一样的
        // p1.name p2.name 都是直接赋值，而没有使用new

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2); // false
    }
}

class Person1{
    public String name;

    public Person1(String name){
        this.name = name;
    }

    public Person1(){

    }

}
