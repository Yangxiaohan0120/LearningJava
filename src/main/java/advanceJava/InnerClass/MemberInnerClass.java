package advanceJava.InnerClass;

/**
 * @author Chris Yang
 * created 2022-03-13 16:02
 **/

// 成员内部类
// 成员内部类是定义在外部类的成员位置，且没有static修饰

// 1）可以直接访问外部类的所有成员，包括私有的
// 2）可以添加任意访问修饰符（public，protected，默认，private）
// 3）作用域：整个类体。在外部类的成员方法中创建成员内部类对象，再调用方法
// 4）成员内部类 -- >  访问  -- > 外部类   ：   直接访问
// 5）外部类   -- >  访问  -- >  内部类   ： 创建对象，再访问
// 6）外部其他类 -- >  访问  -- > 成员内部类

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer08 outer081 = new Outer08();
        outer081.t1();

        // 外部其他类访问内部类
        // 1）使用外部类对象引用一个新的内部类对象。 相当于把new Inner08 作为 outer08的成员
        Outer08 outer08 = new Outer08();
        Outer08.Inner08 inner08 = outer08.new Inner08();

        // 2）建立一个方法返回内部类的实例。
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
    }
}

class Outer08{
    private int n1 = 10;
    public String name = "张三";

    // 成员内部类：定义在外部类的成员位置上
    class Inner08{
        public void say(){
            System.out.println("Outer08 的 n1 = " + n1 + " outer08 的 name = "+ name);
        }
    }

    public void t1(){
        Inner08 inner08 = new Inner08();
        inner08.say();
    }

    // 返回Inner08的实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }
}