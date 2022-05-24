package Multithreading;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Chris Yang
 * created 2022-05-20 13:56
 **/
public class ForkJoinPool_ {

    ForkJoinPool forkJoinPool;
    RecursiveAction recursiveAction;
    RecursiveTask recursiveTask;

    class Fibonacci extends RecursiveTask<Integer> {

        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            } else {
                Fibonacci f1 = new Fibonacci(n - 1);
                // 进一步的去分割子任务
                f1.fork();
                Fibonacci f2 = new Fibonacci(n - 2);
                f2.fork();
                return f1.join() + f2.join();
            }
        }
    }

    @Test
    public void TestFibonacci() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        System.out.println("CPU核数" + Runtime.getRuntime().availableProcessors());
        long startTime = System.nanoTime();

        Fibonacci fibonacci = new Fibonacci(4);
        Future<Integer> fibonacciFuture = forkJoinPool.submit(fibonacci);
        System.out.println(fibonacciFuture.get());

        long endTime = System.nanoTime();

        System.out.println(String.format("总耗时%d", endTime - startTime));
    }


}


class MR extends RecursiveTask<Map<String, Long>> {

    private String[] wc;
    private int start, end;

    public MR(String[] wc, int start, int end) {
        this.wc = wc;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<String, Long> compute() {
        if(end - start == 1){
            return cal(wc[start]);
        }else {
            int mid = start + (end - start) /2;
            MR m1 = new MR(wc,start,mid);
            m1.fork();
            MR m2 = new MR(wc,mid,end);
            m2.fork();
            return merge(m1.compute(),m2.join());
        }
    }

    private Map<String,Long> merge(Map<String,Long> m1,Map<String,Long> m2){
        Map<String,Long> result = new HashMap<>();
        result.putAll(m1);
        m2.forEach( (k,v) ->{
            Long c = result.get(k);
            if(c != null){
                result.put(k,c+v);
            }else {
                result.put(k,v);
            }
        });
        return result;
    }

    private Map<String,Long> cal(String line){
        Map<String,Long> result = new HashMap<>();
        String[] words = line.split("\\s+");
        for(String w : words){
            Long v = result.get(w);
            if(v != null){
                result.put(w,v+1L);
            }else {
                result.put(w,1L);
            }
        }
        return result;
    }

    @Test
    public static void main(String[] args) {
        String[] wc = {"hello world","hello Mark","Mark Good afternoon","fork and join","ThreadPool"};
        MR mr = new MR(wc,0,wc.length);

        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        Map<String,Long> result = forkJoinPool.invoke(mr);

        result.forEach((k,v) -> {
            System.out.println("Key : " + k + " ; Value : " + v);
        });
    }
}
