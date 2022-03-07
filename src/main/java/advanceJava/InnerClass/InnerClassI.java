package advanceJava.InnerClass;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 9:52 PM
 */

// 类的五大成员 1）属性 2）方法 3）构造器 4）代码块 5）内部类

// 基本语法
// class outer{
//     class inner{
//     }
// }
// class other{
// }

//内部类的四种类型：
// 1. 定义在外部类局部的位置上 （比如方法中、代码块中）
// 1）局部内部类（有类名）2）匿名内部类（没有类名）
// 2. 定义在外部类的成员位置上
// 1）成员内部类（没有static修饰）2）静态内部类（使用static修饰）


public class InnerClassI {

    public static void main(String[] args) {

    }

}

class Outer { //外部类
    private int n1 = 100;

    public void m1() {
        System.out.println("m1()");
    }

    public Outer(int n1) {
        this.n1 = n1;
    }

    {
        System.out.println("code block");
    }

    class Inner { //内部类

    }
}