package Multithreading;

import java.util.concurrent.*;

/**
 * @author Chris Yang
 * created 2022-05-06 14:28
 **/
public class ThreadPoolExecutor_ implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        int Run = -1;
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(Run));

        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>(5);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,30,60, TimeUnit.MILLISECONDS,linkedBlockingDeque);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,20,60, TimeUnit.MILLISECONDS,linkedBlockingDeque,handler);

        for (int i = 0; i < 32; i++) {
            threadPoolExecutor.execute(new Thread(new ThreadPoolExecutor_(), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPoolExecutor.getPoolSize());
            if(linkedBlockingDeque.size() > 0){
                System.out.println("======================");
                System.out.println("队列中阻塞的任务数目： "+ linkedBlockingDeque.size());
            }
        }
        threadPoolExecutor.shutdown();
    }
}
