package advanceJava.CodeBlock;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 1:39 PM
 */
public class CodeTest {

    public static void main(String[] args) {
        System.out.println("total = " + Person.total); // 类直接访问静态属性，会直接加载类（则会加载代码块）
        System.out.println("total = " + Person.total);
        // 结果
        // in static block !
        // total = 100
        // total = 100

        Test a = new Test();
        // 静态属性，静态代码块，（按写字顺序），普通属性，默认构造器
        // 静态成员sam初始化
        // static块执行
        // sam1成员初始化
        // Test 默认构造器被调用
    }
}

class Person {

    public static int total; // 静态属性

    static { // 静态代码块
        total = 100;
        System.out.println("in static block !");
    }
}

class Sample{
    Sample(String s){
        System.out.println(s);
    }
    Sample(){
        System.out.println("Sample 默认构造器被调用");
    }
}

class Test{
    Sample sam1 = new Sample("sam1成员初始化");
    static Sample sam = new Sample("静态成员sam初始化");
    static{
        System.out.println("static块执行");
        if(sam == null) System.out.println("sam is null");
    }
    Test(){
        System.out.println("Test 默认构造器被调用");
    }
}

