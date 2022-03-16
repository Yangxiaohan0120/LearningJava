package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-14 19:24
 **/
public class IntegerInterview {
    public static void main(String[] args) {
//        f1();
        f2();
    }

    @SuppressWarnings({"all"})
    public static void f1(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // true --> false
        // 是否是同一个对象

        Integer m = 1; // Integer.valueOf(1) --> 阅读源码 always cache values in the range -128 to 127,
        // 如果有则从缓存中返回
        Integer n = 1;
        System.out.println(m == n); // true

        // 如果不在 -128 ～ 127 则返回一个new
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // true --> false
    }

    @SuppressWarnings({"all"})
    public static void f2(){
        Integer i1 = new Integer(127); // 只要是new 就一定是不同的对象，false
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2); // false

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4); // false

        Integer i5 = 127; // Integer.valueOf(127) 判断是否在范围
        Integer i6 = 127;
        System.out.println(i5 == i6); // true

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8); // false

        Integer i9 = 127;
        Integer i10 = new Integer(127); // new 的新对象肯定是不同的
        System.out.println(i9 == i10); // true --> false

        Integer i11 = 127; // 只要有基本数据类型，那就是判断值是否相等
        int i12 = 127;
        System.out.println(i11 == i12); // true

        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14); // true
    }
}
