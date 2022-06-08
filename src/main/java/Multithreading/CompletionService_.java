package Multithreading;

import java.util.ArrayList;
import java.util.HashMap;
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
    static CompletionService<String> cs = new ExecutorCompletionService<>(executor);

    static List<Future<String>> results = new ArrayList<>(3);


    // 相对复杂，保证有先后
    static String getService(int roomNumber) {
        if(fib2(roomNumber) < 10){
            return roomNumber + " : 0";
        }else if(fib2(roomNumber) < 50){
            return roomNumber + " : 1";
        }else if(fib2(roomNumber) < 300){
            return roomNumber + " : 2";
        }else {
            return roomNumber + " : 3";
        }
    }

    static HashMap<Integer, Integer> memo = new HashMap<>();

    private static int fib2(int n){
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(!memo.containsKey(n)){
            memo.put(n,fib2(n-1) + fib2(n-2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        results.add(cs.submit(() -> getService(900)));
        results.add(cs.submit(() -> getService(300)));
        results.add(cs.submit(() -> getService(3)));

        String r = null;

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
