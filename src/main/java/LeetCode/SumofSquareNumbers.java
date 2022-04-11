package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chris Yang
 * created 2022-04-08 11:49
 **/

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int[] nums = new int[c];


        for (int i = 1; i < c+1; i++) {
            nums[i] = i * i;
        }

        int l = 0, r = c ;
        while (l <= r) {
            if ((nums[l] + nums[r]) < c) {
                l++;
            } else if ((nums[l] + nums[r]) > c) {
                r--;
            } else {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int c = 1;
        boolean res = new SumofSquareNumbers().judgeSquareSum(c);
        System.out.println(res);
    }
}
