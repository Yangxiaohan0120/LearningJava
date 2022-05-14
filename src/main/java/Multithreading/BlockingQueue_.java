package Multithreading;

import java.util.concurrent.*;

/**
 * @author Chris Yang
 * created 2022-05-07 20:04
 **/
public class BlockingQueue_ {
    public static void main(String[] args) {
        BlockingQueue<Runnable> runnableBlockingQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<Runnable> runnableBlockingQueue1 = new LinkedBlockingQueue<>(5);
        BlockingQueue<Runnable> runnableBlockingQueue3 = new SynchronousQueue<>();
        BlockingQueue<Runnable> runnableBlockingQueue4 = new PriorityBlockingQueue<>(5);


        // 插入线程
        runnableBlockingQueue.add(new Thread());
        runnableBlockingQueue.offer(new Thread());
        try {
            runnableBlockingQueue.put(new Thread());
        }catch (Exception e){
            e.printStackTrace();
        }

        // 移除线程
        runnableBlockingQueue.remove(new Thread());
        runnableBlockingQueue.poll();
        try {
            runnableBlockingQueue.take();
        } catch (Exception e){
            e.printStackTrace();
        }

        // 检查方法
        runnableBlockingQueue.element();
        runnableBlockingQueue.peek();



    }
}
