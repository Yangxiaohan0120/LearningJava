package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-02 17:53
 **/
public class Numberof1Bits {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }
}
