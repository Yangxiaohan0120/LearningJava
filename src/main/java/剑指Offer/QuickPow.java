package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-25 09:39
 **/

// 简直是困难级别

public class QuickPow {

    public double myPowStandard(double x, int n){
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double myPow(double x, int n) {
        double res = 1;
        if(x == 0)return 0;
        if(x == 1)return 1;
        if ( n < 0){
            x = 1 / x;
            n = -n;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public double myPow1(double x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        double base = 2.1;
        int num = 3;
        double res = new QuickPow().myPow(base, num);
        double res1 = Math.pow(base, num);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res == res1);
    }
}
