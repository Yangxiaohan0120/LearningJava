package advanceJava.InnerClass;

/**
 * @author Chris Yang
 * @create 2022-03-13 17:10
 **/

// 静态内部类
// 静态内部类是定义在外部类的成员位置，并且有static 修饰


// 1）直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
// 2）可以添加任意访问修饰符
// 3）作用域：同其他的成员，为一个类体。
// 4）访问外部类：直接访问
// 5）外部类访问：创建对象再访问

public class StaticInnerClass {
    public static void main(String[] args) {

    }
}

class Outer03{
    private int n1 = 10;
    private static String name = "aa";

    static class Inner03{ //private public protected
        public void say(){
            System.out.println(name);
        }
    }

    public void m1(){
        Inner03 inner03 = new Inner03();
        inner03.say();
    }
}
