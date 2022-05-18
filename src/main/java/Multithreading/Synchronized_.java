package Multithreading;

/**
 * @author Chris Yang
 * created 2022-05-17 20:49
 **/
public class Synchronized_ implements Runnable {


    public static void main(String[] args) {

    }

    @Override
    public void run() {

    }
}

class AddI {
    public static volatile int i1 = 0;
    public static volatile int i2 = 0;
    public static volatile int i3 = 0;
    Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 方式一：修饰静态方法
        Thread t1 = new Thread(() -> add(10000));
        Thread t2 = new Thread(() -> add(10000));

        // 方式二：修饰普通方法
        AddI addI = new AddI();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                addI.add2(10000);
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                addI.add2(10000);
            }
        });

        // 方式三：修饰代码块
        AddI addI1 = new AddI();
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                addI1.add3(10000);
            }
        });;
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                addI1.add3(10000);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t3.start();
        // 主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法
        // Waits for this thread to die.
        t3.join();
        t4.start();
        t4.join();

        t5.start();
        t5.join();
        t6.start();
        t6.join();

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

    }

    // synchronized 修饰静态方法
    public static synchronized void add(int n){
        for (int j = 0; j < n; j++) {
            i1++;
        }
    }

    // synchronized 修饰普通方法
    public synchronized void add2(int n){
        for (int j = 0; j < n; j++) {
            i2++;
        }
    }

    // 代码块加锁
    public void add3(int n){
        synchronized (object) {
            for (int j = 0; j < n; j++) {
                i3++;
            }
        }
    }
}
