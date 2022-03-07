package advanceJava.InnerClass;

/**
 * @ author: yxh
 * @ created: 2022-02-28 : 9:48 PM
 */
public class AnonymousDetailI {

    public static void main(String[] args) {

        Outer05 outer05 = new Outer05();
        outer05.f1();

    }
}


// 使用细节：
// 可以直接访问外部类的所有成员，包括私有的
// 不能添加访问修饰符
// 作用域：仅仅在定义它的方法或代码块汇总
// 匿名内部类 -- 访问 -----> 外部类成员（直接访问）
// 外部其他类 -- > 不能访问匿名内部类
// 外部类和内部类的成员重名，内部类访问的就近原则

class Outer05 {
    private int n1 = 99;

    public void f1() {

        // 只能使用一次
        Person p = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法");
            }
        };
        p.hi();

        // 可以直接调用
        new Person() {
            @Override
            public void hi() {
                System.out.println("直接调用不生成对象。。。");
            }

            @Override
            public void ok(String name) {
                System.out.println("直接调用ok");
            }
        }.ok("Jack"); // 直接使用不将对象返回
    }
}

class Person {
    public void hi() {
        System.out.println("Person() hi");
    }

    public void ok(String name) {
        System.out.println(name + ",hi");
    }
}