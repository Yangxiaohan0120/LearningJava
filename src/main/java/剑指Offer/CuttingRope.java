package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-23 17:34
 **/
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] res = new int[n + 1];
        res[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                res[i] = Math.max(res[i],Math.max(j * (i - j), j * res[i-j]));
            }
        }
        return res[n];
    }

    public static void main(String[] args) {

    }
}
