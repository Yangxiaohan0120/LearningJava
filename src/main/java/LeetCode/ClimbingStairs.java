package LeetCode;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 2:48 PM
 */
public class ClimbingStairs {

    HashMap<Integer, Integer> nStairs = new HashMap<>();

    public int climbStairs(int n) {
        return calculate3(n);
    }

    private int calculate(int n) {
//        if (n == 0) return 1; // 可与n == 2 替换
        if (n == 1) return 1;
        if (n == 2) return 2;
        return calculate(n - 1) + calculate(n - 2);
    }

    private int calculate2(int n){
        nStairs.put(0,1);
        nStairs.put(1,1);
        for (int i = 2; i <= n; i++) {
            nStairs.put(i,nStairs.get(i-1)+nStairs.get(i-2));
        }
        return nStairs.get(n);
    }

    private int calculate3(int n){
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n-1];

//        int[] memo = new int[n+1];
//        memo[0] = 1;
//        memo[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            memo[i] = memo[i-1] + memo[i-2];
//        }
//        return memo[n];
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(new ClimbingStairs().climbStairs(n));
    }

}