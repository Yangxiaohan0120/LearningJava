package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 8:58 PM
 */


// 1) 接口不可以被实例化
// 2) 接口中所有的方法都是public，抽象方法可以不使用abstract修饰
// 3） 一个普通类实现接口，必须实现接口的所有方法
// 4） 抽象类实现接口 ，可以不用实现接口的所有方法
// 5） 一个类可以同时实现多个接口
// 6） 接口中的属性只能是final的，且是public static final （int a = 1 相当于 public static final int a = 1)
// 7) 接口中属性的访问形式： 接口名.属性名
// 8） 一个接口不能继承其他的类，但可以继承多个别的接口
// 9） 接口的修饰符只能是public 和 默认

public class InterfaceDetailI {

    public static void main(String[] args) {
//        new IA(); // 1) 接口不可被实例化

        System.out.println(IB.a); // 通过接口直接访问属性，说明是static
//        IB.a = 40;  // 不可更改，说明是final
    }
}

interface IA {
    public void say(); // abstract void say();
//    protected void hi(); // protected
//    private void hi(); // private
}

interface IB {
    int a = 1 ; // 等价 ==> public static final int a = 1;
    public void sleep();
}

// extends 继承
// implements 实现

interface IC extends IA,IB{
    // 一个接口可以继承多个其他的接口
}


class Cat implements IA {
    @Override
    public void say() { // 必须使用public

    }
}

// 5）一个类同时实现了多个接口
class Pig implements IA,IB{
    @Override
    public void say() {

    }

    @Override
    public void sleep() {

    }
}

