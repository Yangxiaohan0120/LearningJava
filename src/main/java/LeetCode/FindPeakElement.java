package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-14 22:15
 **/

//A peak element is an element that is strictly greater than its neighbors.
//
//Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//
//You may imagine that nums[-1] = nums[n] = -∞.
//
//You must write an algorithm that runs in O(log n) time.

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[1] > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    return -1;
                }
            }

            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    return -1;
                }
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int index = new FindPeakElement().findPeakElement(nums);
        System.out.println(index); // index = 2(3)
    }
}
