package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-31 19:29
 **/

// 返回最大的整数平方根

public class Sqrtx {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int l = 1, r = x/2;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int num = mid*mid;
            if (num < x) {
                l = mid + 1;
            } else if( num > x ){
                r = mid - 1;
            }else return mid;
        }

        return r;
    }
}
