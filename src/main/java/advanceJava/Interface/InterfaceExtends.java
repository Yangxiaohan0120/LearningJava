package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 9:15 PM
 */

// Extends Vs implements

// 继承（extends）会直接得到父类的功能

// 1) 接口和继承解决的问题不同： 继承：实现代码的复用性和可维护性； 接口： 设计，规范，灵活使用
// 2) 接口比继承更加灵活： 继承满足 is 接口满足 like
// 3) 接口在一定程度上实现了代码解耦 （接口的规范性）

public class InterfaceExtends {

    public static void main(String[] args) {
        littleMonkey m = new littleMonkey("悟空");
        // 自动继承父类的功能，不需要额外的去实现
        m.climbing();
        // 接口中的方法，必须通过重写来进行实现
        m.swimming();
        m.flying();
    }
}


class Monkey {
    public String name;

    public void climbing() {
        System.out.println(name + "会爬树");
    }

    public Monkey(String name) {
        this.name = name;
    }
}

class littleMonkey extends Monkey implements Fishable, Flyable {

    public littleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(name + "通过学习，学会了游泳");
    }

    @Override
    public void flying() {
        System.out.println(name + "通过学习，学会了飞翔");
    }
}

interface Fishable {
    void swimming();
}

interface Flyable {
    void flying();
}

