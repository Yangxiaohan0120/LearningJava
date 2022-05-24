package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Chris Yang
 * created 2022-05-22 17:48
 **/
public class PoolMethod {
    public static void main(String[] args) {

    }
}


// 一般的池化资源的写法：
class poolDemo {
    Thread acquire() {
        return new Thread();
    }

    void release() {

    }

}

class MyThreadPoolDemo {
    BlockingQueue WorkQueue;
    List<WorkThread> threads = new ArrayList<>();

    public MyThreadPoolDemo(int size, BlockingQueue blockingQueue) {
        this.WorkQueue = blockingQueue;
        for (int i = 0; i < size; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            threads.add(workThread);
        }
    }

    void execute(Runnable command) throws InterruptedException {
        WorkQueue.put(command);
    }

    class WorkThread extends Thread {
        public void run() {

            try {
                Runnable task = (Runnable) WorkQueue.take();
                task.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        MyThreadPoolDemo poolDemo = new MyThreadPoolDemo(3, blockingQueue);

        poolDemo.execute(() -> {
            System.out.println("Hello");
        });
    }
}