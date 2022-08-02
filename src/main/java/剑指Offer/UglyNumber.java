package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-01 12:23
 **/
public class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2,n3),n5);
            if(res[i] == n2)a++;
            if(res[i] == n3)b++;
            if(res[i] == n5)c++;
        }
        return res[n-1];
    }
}
