package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-23 17:53
 **/
public class CuttingRopeII {

    int mod = 1000000007;
    // 分成 以3为长度的小段，乘积最大，若不能整除，则乘以3或者乘以4
    public int cuttingRope(int n) {
        if(n < 4) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if(b == 0) return (int) (myPow(3, a) % mod);
        else if(b == 1) return (int) (myPow(3, a - 1) * 4 % mod);
        else return (int) (myPow(3, a) * 2 % mod);
    }

    public long myPow(long base, int num) {
        long res = 1;
        while (num > 0) {
            if ((num & 1) == 1) {
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }

    public int cuttingRopeII(int n) {
        int[] res = new int[n + 1];
        res[2] = 1 % 1000000007;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                res[i] = Math.max(res[i],Math.max(j * (i - j) % 1000000007, j * res[i-j] % 1000000007));
            }
        }
        return res[n];
    }
}
