package Multithreading;

/**
 * @author Chris Yang
 * created 2022-03-08 15:28
 **/
public class volatileTest03 {
    private static Object lock = new Object();
    public static volatile int num = 0;

    static class A implements Runnable {

        @Override
        public void run() {
            while (num < 10) {
                if (num % 2 == 0) {
                    System.out.println("ThreadA : " + num);
                    synchronized (lock) {
                        num++;
                    }
                }
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            while (num < 10) {
                if (num % 2 == 1) {
                    System.out.println("ThreadB : " + num);
                    synchronized (lock) {
                        num++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new A()).start();
        Thread.sleep(1);
        new Thread(new B()).start();
    }
}
