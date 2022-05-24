package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Chris Yang
 * created 2022-05-23 13:36
 **/


//    Future<V> submit(Callable<V> task);
//    Future<V> submit(Runnable task, V result);
//    Future<V> take() throws InterruptedException;
//    Future<V> poll();
//    Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;

public class CompletionService_ {

    static int getService(int roomNumber) {
        return roomNumber + 1;
    }

    static void save(int r) {
        System.out.println(r);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);

        cs.submit(() -> getService(1));
        cs.submit(() -> getService(2));
        cs.submit(() -> getService(3));

        for (int i = 0; i < 3; i++) {
            Integer s = cs.take().get();
            executor.execute(() -> save(s));
        }

        executor.shutdown();
    }
}

// 同时向三个地图服务供应商查询路线，只要有一个成功查询到就返回

class MapServiceDemo {

    static ExecutorService executor = Executors.newFixedThreadPool(3);
    static CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);

    static List<Future<Integer>> results = new ArrayList<>(3);

    static int getService(int roomNumber) {
        return roomNumber + 1;
    }

    static void save(int r) {
        System.out.println(r);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        results.add(cs.submit(() -> getService(1)));
        results.add(cs.submit(() -> getService(2)));
        results.add(cs.submit(() -> getService(3)));

        Integer r = 0;

        try {
            for (int i = 0; i < 3; i++) {
                r = cs.take().get();
                if (r != null) {
                    break;
                }
            }
        } finally {
            for (Future f : results) {
                f.cancel(true);
            }
        }

        System.out.println(r);
        executor.shutdown();
    }
}
