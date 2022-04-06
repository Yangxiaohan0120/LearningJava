package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-04-02 17:07
 **/
public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int max = -1;
        int min = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                int t = mid;
                while (t < nums.length - 1 && nums[t + 1] == nums[t]) {
                    t++;
                }
                max = t;
                t = mid;
                while (t > 0 && nums[t - 1] == nums[t]) {
                    t--;
                }
                min = t;
                return new int[]{min,max};
            }
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 8, 8, 9};
        int target = 8;
        int[] res = searchRange(arr, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
