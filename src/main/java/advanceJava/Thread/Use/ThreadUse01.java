package advanceJava.Thread.Use;

/**
 * @author Chris Yang
 * created 2022-04-11 17:04
 **/

// 多线程的创建有两种方式：
// 1. 继承Thread类，重写run方法
// 2. 继承Runnable类，重新run方法

// 1.编写一个线程，每隔一秒输出"喵喵喵"
// 2.输出80次后终止
// 3.使用JConsole监控线程执行 情况
public class ThreadUse01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();

        // public synchronized void start() {
        // try {
        //      start0();
        //      started = true;
        //  } finally {
        // start0() 是本地方法，是JVM调用, 使用底层的c/c++实现
        // 真正实现多线程的效果， 是start0(), 而不是 run
        // Native methods are Java™ methods that start in a language other than Java. Native methods can access
        // system-specific functions and APIs that are not available directly in Java.

        cat.start();//启动线程-> 最终会执行cat的run方法

        //cat.run();//run方法就是一个普通的方法, 没有真正的启动一个线程，就会把run方法执行完毕，才向下执行
        //说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行
        //这时 主线程和子线程是交替执行..
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字main
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }

    }

//老韩说明
//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的run方法
/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */


}

class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵喵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            times++;
            if (times == 10) {
                break;
            }
        }
    }
}
