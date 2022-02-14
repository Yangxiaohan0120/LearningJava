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
        return breakInteger2(n);
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
        memo.put(1,1);
        memo.put(2,1);
        for (int i = 3; i <= n; i++) {
            memo.put(i,-1);
        }

        for (int i = 3; i <= n; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i-1 ; j++) {
                // 对i进行分割 j*(i-j) ... 对（i-j) 进一步分割
                int max = max3(memo.get(i), j * (i - j), j * memo.get(i-j));
                memo.put(i,max);
            }
        }

        return memo.get(n);
    }

    private int breakInteger3(int n) {
        memo1 = new int[n + 1];
        memo1[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                // 对i进行分割 j*(i-j) ... 对（i-j) 进一步分割
                memo1[i] = max3(memo1[i], j * (i - j), j * memo1[i - j]);
            }
        }

        return memo1[n];

    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int n = 30;
        long startTime = System.nanoTime();
        int res = new IntegerBreak().IntegerBreak(n);
        long endTime = System.nanoTime();
        System.out.println("Max Sum : " + res + ", takes "+ (double) (endTime - startTime) / 1000000 + " ms.");
    }
}