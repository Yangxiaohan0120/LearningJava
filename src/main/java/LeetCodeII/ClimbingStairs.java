package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:13 PM
 */
public class ClimbingStairs {

    // n = n-1 + n-2
    public int climbStairs(int n){
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

}