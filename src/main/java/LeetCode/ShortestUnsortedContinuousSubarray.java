package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-05-03 20:28
 **/

// Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in
// ascending order, then the whole array will be sorted in ascending order.
//
// Return the shortest such subarray and output its length.

// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums1[i]){
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != nums1[i]){
                end = i;
                break;
            }
        }
        if (end == start) {
            return 0;
        } else {
            return end - start + 1;
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums1 = {1, 3, 2, 2, 2};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums1));
    }
}
