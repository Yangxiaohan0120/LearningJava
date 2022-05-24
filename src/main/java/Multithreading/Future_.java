package Multithreading;

import javafx.concurrent.Task;

import java.util.concurrent.*;

/**
 * @author Chris Yang
 * created 2022-05-22 18:00
 **/
public class Future_ {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future;

        // Future 提交任务
        // Runnable
        RunDemo runDemo1 = new RunDemo();
        RunDemo runDemo2 = new RunDemo();
        Future future1 = executorService.submit(runDemo1);
        int result1 = 1;
        Future future2 = executorService.submit(runDemo2,result1);

        // Callable
        CallDemo callDemo = new CallDemo();
        Future<CallDemo> callDemoFuture = executorService.submit(callDemo);
    }
}

class RunDemo implements Runnable {

    @Override
    public void run() {

    }
}


class CallDemo implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}


class TeaMake{
    static FutureTask<String> task2 = new FutureTask<>(new TaskT2());

    static FutureTask<String> task1 = new FutureTask<>(new TaskT1(task2));


    static class TaskT1 implements Callable{

        FutureTask<String> f2;

        TaskT1(FutureTask<String> futureTask){
            this.f2 = futureTask;
        }


        @Override
        public String call() throws Exception {
            System.out.println("洗水壶。。。。。。");
            TimeUnit.SECONDS.sleep(20);

            System.out.println("烧开水。。。。。。");
            TimeUnit.MINUTES.sleep(2);

            System.out.println("加茶叶：" + f2.get());

            System.out.println("泡茶。。。。。。");
            TimeUnit.SECONDS.sleep(30);

            return "上茶：" + f2.get();
        }
    }

    static class TaskT2 implements Callable{

        @Override
        public String call() throws Exception {
            System.out.println("洗茶杯。。。。。。");
            TimeUnit.SECONDS.sleep(20);

            System.out.println("拿茶叶。。。。。。");
            TimeUnit.MINUTES.sleep(1);

            return "普洱";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(task1);
        T1.start();
        Thread T2 = new Thread(task2);
        T2.start();
        T1.join();
        T2.join();
        System.out.println("品茶");
    }

}