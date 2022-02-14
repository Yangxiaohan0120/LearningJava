package LC;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 3:02 PM
 */
public class IntegerBreak {

    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] memo1;

    public int IntegerBreak(int n) {
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) return 1;

        int res = -1;

        for (int i = 1; i < n; i++) {
            // i * (n-i) 只分割为两个，后面的不分割；
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        return res;
    }

    private int breakInteger2(int n) {
        if (n == 1) memo.put(1, 1);
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(res, i * (n - i), i * memo.get(n - i));
            memo.put(i, res);
        }

        return memo.get(n);
    }

    private int breakInteger3(int n) {
        memo1 = new int[n];
        memo1[0] = 1;
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(res, i * (n - i), i * memo1[n-i-1]);
            memo1[n-i-1] = res;
        }
        return memo1[n-1];

//        memo1 = new int[n+1];
//        memo1[0] = 0;
//        memo1[0] = 1;
//        int res = -1;
//        for (int i = 2; i <= n; i++) {
//            res = max3(res, i * (n - i), i * memo1[n-i]);
//            memo1[n-i] = res;
//        }
//        return memo1[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int n = 30;
        long startTime = System.nanoTime();
        int res = new IntegerBreak().breakInteger(n);
        long endTime = System.nanoTime();
        System.out.println("Max Sum : " + res + ", takes "+ (double) (endTime - startTime) / 1000000 + " ms.");
    }
}