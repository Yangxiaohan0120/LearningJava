package LC;

import java.util.HashMap;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 2:25 PM
 */
public class FibonacciSequence {

    // 斐波那契数列的实现

    // complexity (2^n)
    HashMap<Integer, Integer> memo = new HashMap<>();

    private int fib(int n){
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(!memo.containsKey(n)){
            memo.put(n,fib(n-1) + fib(n-2));
        }
        return memo.get(n);
    }

    // 自下而上解决问题
    private int fib2(int n){
        memo.put(0,0);
        memo.put(1,1);
        for (int i = 2; i < n; i++) {
            memo.put(i,memo.get(i-1)+memo.get(i-2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 50; // 可能会溢出变成负数
        long startTime = System.nanoTime();
        int res = new FibonacciSequence().fib(n);
        long endTime = System.nanoTime();

        System.out.println("fib " + n+ " : " + res + " , costs " + (double) (endTime - startTime) / 1000000 + " ms.");
    }

}