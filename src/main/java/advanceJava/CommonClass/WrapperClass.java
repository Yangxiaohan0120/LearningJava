package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-14 16:56
 **/

// 包装类 基本数据类型对应的包装类

public class WrapperClass {
    public static void main(String[] args) {

//        Boolean a = true;
//        Character b = 'b';
//        Byte c = '0';
        f1();
    }

    public static void f1(){
        // 包装类和基本数据类型的转换：
        // jdk5之前手动装箱拆箱
        // 基本类型 --> 包装类型 装箱，反之拆箱。
        int n1 = 5000;
        Integer integer = new Integer(5000); // 手动装箱
        Integer integer1 = Integer.valueOf(n1); // 手动装箱

        int n2 = integer.intValue(); // 手动拆箱

        // 自动拆箱和装箱
        Integer integer2 = n2; // 自动装箱 调用的Integer.valueOf(n2)
        int n3 = integer2; // 自动拆箱 调用的是intValue()

        // 三元运算符
        Object obj1 = true?new Integer(1) : new Double(2.0);
        System.out.println(obj1); // 1.0 三元运算符是一个整体，使用最高的精确度
    }

    public static void f2(){
        // 包装类转String
        Integer i = 100;
        String str1 = i+"";
        String str2 = i.toString();
        String str3 = String.valueOf(i);

        //String转包装类
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);
        Integer i3 = new Integer(str4);
    }
}
