package Multithreading;

/**
 * @author Chris Yang
 * @create 2022-03-08 15:49
 **/
public class Join {
    static class ThreadOri implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("当前线程准备睡1秒");
                Thread.sleep(1000);
                System.out.println("当前线程休息完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thisOne = new Thread(new ThreadOri());
        thisOne.start();
        thisOne.join();
        System.out.println("加入join，所以等待线程执行完，才可以执行我");
    }
}
