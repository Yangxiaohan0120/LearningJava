package advanceJava.InnerClass;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 10:11 PM
 */

// 1)局部内部类

// 属性：
// 1）直接访问外部类的所有成员，包括私有的
// 2）不能添加访问修饰符。相当于一个局部变量（除了final）
// 3）作用域：仅仅在定义它的方法或者代码块中
// 4）局部内部类 --> 外部类成员   如何访问：直接访问
// 5）外部类 --> 局部内部类成员   如何访问：创建对象再访问
// 6）外部其他类 --> 局部内部类   如何访问：不可访问
// 7）外部类和局部内部类的成员重名时，默认遵循就近原则。（访问外部成员使用 Outer.this.成员）

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m2();
        System.out.println(outer01); // hashcode相同
    }
}

class Outer01{
    private int n1 = 100;

    public void m1(){
        System.out.println("m1()");
    }

    public void m2() {
        final class Inner02 {// 2）只可以使用final修饰
            private int n1 = 200;
            public void f1(){
                System.out.println(n1);//1）直接访问外部类的所有成员
                System.out.println(Outer01.this.n1); // 4) 7) 跳过就近原则访问外部类的成员
                System.out.println(Outer01.this); // hashcode值相同，Outer01.this ==> 将外部的对象带入进来。
                m1(); // 3) 作用域使用了外部类的方法
            }
        }
//        public class Inner03 {} // 2）不可以添加其他的访问修饰符
        Inner02 inner02 = new Inner02(); // 5) 新建对象来访问
        inner02.f1();
    }

    {
        class Inner03{} // 在代码块中
    }

}