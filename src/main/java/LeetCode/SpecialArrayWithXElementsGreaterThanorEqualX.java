package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chris Yang
 * created 2022-04-07 15:54
 **/

// You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that
// there are exactly x numbers in nums that are greater than or equal to x.
//
// Notice that x does not have to be an element in nums.
//
// Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.


// 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
//
// 注意： x 不必 是 nums 的中的元素。
//
// 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
//

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                if (nums[n - 1] < i) return i;
            } else if (i == n) {
                if (nums[0] >= i) return i;
            } else {
                if (nums[n - 1 - i] < i && nums[n - i] >= i)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        int res = new SpecialArrayWithXElementsGreaterThanorEqualX().specialArray(nums);
        System.out.println(res);
    }
}
