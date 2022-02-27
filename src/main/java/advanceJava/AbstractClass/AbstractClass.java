package advanceJava.AbstractClass;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 3:05 PM
 */

// 抽象类的使用场景
//父类的方法需要声明，但是又不确定如何实现，可以将其声明为抽象方法，对应的此类变为抽象类


public class AbstractClass {
    public static void main(String[] args) {

    }
}

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("这是一个动物，但是不知道要吃什么");
    }
}