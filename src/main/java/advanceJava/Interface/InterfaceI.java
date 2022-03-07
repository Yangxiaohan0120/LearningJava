package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 8:41 PM
 */

// 接口的概念： 给出一些没有实现的方法封装到一起，在使用时再具体实现
// jdk 7.0 之前所有的方法都没有方法体
// jdk 8.0 之后可以有属性、静态方法或者默认方法



public class InterfaceI {
    public static void main(String[] args) {
        // 创建手机
        Phone phone = new Phone();

        Computer computer = new Computer();
        computer.work(phone); // 把手机接入到电脑中
    }
}

