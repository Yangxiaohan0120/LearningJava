package Multithreading;

/**
 * @author Chris Yang
 * created 2022-03-08 15:20
 **/
public class volatileTest01 {
    private static Object lock = new Object();
    public static volatile int num = 0;

    static class A implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + num);
                        num ++;
                        lock.notify();
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class B implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + num);
                        num++;
                        lock.notify();
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new A()).start();
        Thread.sleep(1000);
        new Thread(new B()).start();
    }
}
