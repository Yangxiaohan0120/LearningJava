package advanceJava.AbstractClass;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 3:26 PM
 */

// 抽象类的介绍
// 1）使用abstract来进行修饰的类，称之为抽象类： 使用： abstract 类名{}
// 2）使用abstract类进行方法的修饰时，这个方法称之为抽象方法： 使用： abstract 返回类型 方法名（参数列表）; // 没有方法体
// 3）抽象类的价值更多的在于设计，是设计者设计好后，由子类继承并实现

// 1） 抽象类不能被实例化
// 2） 抽象类不一定要包含抽象方法
// 3） 一旦类中包含了抽象方法，那么这个类一定要声明为抽象类
// 4） abstract只能修饰类和方法，不能修饰属性和其他的
// 5） 抽象类可以有任意成员 （非抽象方法、构造器、静态属性）
// 6） 抽象方法不能有主体，即不能实现
// 7） 如果一个类继承了抽象类，他必须实现抽象类中的所有抽象方法，除非他自己本身也是一个抽象类
// 8） 抽象方法不可以使用private,final,static 来修饰

public class AbstractDetailI {

    public static void main(String[] args) {

    }
}

// 抽象类的本质还是类，所以可以有类的其他属性
abstract class D {
    public int n1 = 10;
    public static String name = "小白";

    public void hi() {
        System.out.println("say hi");
    }

    public abstract void hello();

    public static void ok() {
        System.out.println("ok");
    }

}

abstract class E{
    public abstract void hi();
    public abstract void hello();
}


// 所谓实现方法就是有方法体，即使方法体内是空白
class F extends E{

    @Override
    public void hi(){

    }

    @Override
    public void hello(){

    }

}