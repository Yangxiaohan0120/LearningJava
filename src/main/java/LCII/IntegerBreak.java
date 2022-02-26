package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:41 PM
 */
public class IntegerBreak {


    //Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
    //Return the maximum product you can get.

    // 10 ==> 3*3*4 = 36

    public int IntegerBreak(int n){
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                memo[i] = Math.max(memo[i], j * memo[i-j]);
                memo[i] = Math.max(memo[i], j * (i -j));
            }
        }

        return memo[n];
    }

}