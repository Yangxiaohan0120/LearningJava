package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-28 15:29
 **/
public class BinaryNumberwithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        int cur = -1;

        // -1 的二进制表示： 原码取反（反码）+1（补码）
        // 负数的二进制表示是对应的正数的补码
        // 原码： 0000000000000000000000000000001
        // 反码： 1111111111111111111111111111110
        // 补码： 1111111111111111111111111111111
        while (n != 0) {
            int u = n & 1; // 找到最后一位
            int m = cur ^ u;
            if (m == 0) return false;
            cur = u; n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }
}
