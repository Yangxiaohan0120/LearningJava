package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-07 16:22
 **/
public class SpecialArray01 {
    public int specialArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int start = 0;
        int end = max;
        if (max == 0 && nums.length > 0) return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = count(nums, mid);
            if (count == mid) {
                return mid;
            } else if (count > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int count(int[] nums, int k) {
        int count = 0;
        for (int num: nums) {
            if (num >= k) count++;
        }
        return count;
    }
}
