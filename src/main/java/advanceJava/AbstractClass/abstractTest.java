package advanceJava.AbstractClass;

import advanceJava.MainMethod.MainTest;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 3:41 PM
 */

// 练习题：
// 1） abstract final class A{} 编译是否能通过 final不能
// 2） abstract public static void test2(); 编译是否能通过 static不能
// 3） abstract private void test3(); 编译是否能通过 private不能
// 4） 编写一个Employee类，声明为抽象类，包含name，id，salary 提供抽象方法work()
//     Manager 既是员工，又有bonus属性，设计CommonEmployee类和Manager类
public class abstractTest {

    public static void main(String[] args) {
        Manager jack = new Manager("jack",29,50000);
        jack.work();
    }
}

abstract class CommonEmployee {
    private String name;
    private int id;
    private double salary;

    public abstract void work();

    public CommonEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Manager extends CommonEmployee{

    private double bonus;

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work(){
        System.out.println("经理" + getName() + "在工作。。。");
    }
}