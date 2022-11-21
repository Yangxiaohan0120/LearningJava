package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-04 21:49
 **/
public class TheLastNumberInCircle {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + i) % i;
        }
        return res;
    }
}
