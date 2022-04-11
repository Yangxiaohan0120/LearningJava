package LeetCode;

import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-04-10 15:06
 **/
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 32;
        boolean res = new PowerofTwo().isPowerOfTwo(n);
        System.out.println(res);
    }
}
