package Multithreading;

/**
 * @author Chris Yang
 * @create 2022-03-08 13:35
 **/
public class DeepenSleep implements Runnable {
    private int number = 10;

    public void firstMethod() throws Exception {
        synchronized (this) {
            System.out.println("in first method");
            number += 100;
            System.out.println("+100=" + number);
        }
    }

    public void secondMethod() throws Exception {
        synchronized (this) {
            System.out.println("in second method, prepare sleep"); // 2）
            /**
             * (休息2S,阻塞线程) 以验证当前线程对象的机锁被占用时, 是否被可以访问其他同步代码块
             */
            Thread.sleep(2000); // 线程的等待，回到上一个线程 run()
            System.out.println("wake up!!");
            // this.wait(2000);
            number *= 200;
            System.out.println("*200=" + number);
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("run thread..."); // 3）
            firstMethod(); // 执行
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        DeepenSleep dt = new DeepenSleep();
        Thread thread = new Thread(dt);
        thread.start();
        System.out.println("prepare run second method"); // 1）
        dt.secondMethod(); //创建线程的消耗，先执行此行 2）
    }
}

