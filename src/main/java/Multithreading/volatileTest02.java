package Multithreading;

/**
 * @author Chris Yang
 * @create 2022-03-08 15:26
 **/
public class volatileTest02 {
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
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
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
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new A()).start();
        Thread.sleep(1000);
        new Thread(new B()).start();
    }
}
