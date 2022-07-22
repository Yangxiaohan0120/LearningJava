package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 14:51
 **/
public class Fibonacci {
    public int fib(int n) {
        if(n == 1 || n == 0)return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i-1] + memo[i-2])% 1000000007;
        }
        return memo[n] % 1000000007;
    }

    public static void main(String[] args) {
        int res = new Fibonacci().fib(48);
        System.out.println(res);
    }
}
