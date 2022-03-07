package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 9:27 PM
 */


// 接口多态性的体现

// 1） 多态参数
// 2） 多态数组
// 3） 多态传递


public class InterfacePolymorphism {

    public static void main(String[] args) {
        // 接口类型的变量，可以指向实现了接口的类的实例 （ 1）多态参数）
        IF f01 = new Monster();
        IF f02 = new Car();

        // 2）多态数组
        IF[] ifs = new IF[2];
        ifs[0] = new Monster();
        ifs[1] = new Car();

        for (int i = 0; i < ifs.length; i++) {
            ifs[i].work();
//            ifs[i].sleep(); //不是所有的实现类都有sleep 方法
            if(ifs[i] instanceof Monster) //判断运行类型
                ((Monster) ifs[i]).sleep(); // 向下转型
        }

        // 3）多态传递
        IE ie = new Teacher();
        IH ih = new Teacher();
        IG ig = new Teacher();
    }

}

class Computer1 {
    // 1） 可以接收所有实现了UsbInterface的类的实例 （多态参数）
    public void work(UsbInterface usbInterface) {
        usbInterface.start();
        usbInterface.stop();
    }
}

interface IF {
    void work();
}

class Monster implements IF {
    @Override
    public void work(){
        System.out.println("eating");
    }

    public void sleep(){
        System.out.println("sleeping");
    }
}

class Car implements IF {
    @Override
    public void work(){
        System.out.println("driving");
    }

    public void stop(){
        System.out.println("stopped");
    }
}

interface IE{}
interface IH extends IE{}
interface IG extends IH{}
class Teacher implements IG{}