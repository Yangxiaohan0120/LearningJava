package advanceJava.InnerClass;

/**
 * Important !!!!!!
 *
 * @ author: yxh
 * @ created: 2022-02-28 : 8:48 PM
 */

// 1）本质还是个类 2）内部类 3）匿名 4）同时是一个对象

// 使用基本语法
// new 类或接口（参数列表）{
//     类体;
// };
public class anonymousClass {
    public static void main(String[] args) {
        new Outer02().method();
    }
}

class Outer02{
    private int n1 = 10;
    public void method(){
        // 1.基于接口的匿名内部类
        // 使用匿名类简化开发，应用于仅仅使用一次的类
        // tiger的编译类型：等号左边 A
        // tiger的运行类型：匿名内部类
        /* 底层原理：类名为 XXX ==> Outer02$1
            class XXX implements A{
               @Override
               public void cry(){
                    System.out.println("嗷呜嗷呜。。。");
               }
            }
         */
        // jdk 底层创建匿名内部类Outer02$1，立即创建了Outer02$1实例，并返回给tiger。
        // 匿名内部类使用一次后就不能再次使用（tiger可以继续使用）
        A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("嗷呜嗷呜。。。");
            }
        };
        System.out.println("tiger的运行类型："+ tiger.getClass()); // 输出运行类型
        tiger.cry();

        // ===================

        // 2.基于类的匿名内部类
        // father的编译类型：Father
        // father的运行类型：Outer01$2
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();
        System.out.println("father的运行类型：" + father.getClass());
        Father father1 = new Father("Rose");
        System.out.println("father1的运行类型：" + father1.getClass());

        // =========

        // 3.基于抽象类的匿名内部类
        Animal dog = new Animal(){
            // 必须实现抽象类的方法
            @Override
            void eat() {
                System.out.println("eating bones ...");
            }
        };
        dog.eat();
    }
}

interface A{
    public void cry();
}

class Father{
    public Father(String name){

    }

    public void test(){

    }
}

abstract class Animal{
    abstract void eat();
}