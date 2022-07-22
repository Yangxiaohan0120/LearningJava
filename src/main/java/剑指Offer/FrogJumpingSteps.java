package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 15:04
 **/
public class FrogJumpingSteps {
    public int numWays(int n) {
        if(n == 0 || n == 1 )
            return 1;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = (res[i-1] + res[i-2]) % 1000000007;
        }
        return res[n] % 1000000007;
    }
}
