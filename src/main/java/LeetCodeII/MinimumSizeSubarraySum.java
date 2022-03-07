package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 4:28 PM
 */
public class MinimumSizeSubarraySum {

    // 和大于阈值的最短连续子数组
    // 给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和sum >= s，返回这个最短的连续子数组的返回值。
    public int MinimumSizeSubarraySum(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int res = nums.length + 1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length+1)
            return 0;
        else return res;

    }

    public static void main(String[] args) {
        int sum = 6;
        int[] nums = {1,4,5,2,7};
        String s = "abda";
        System.out.println(new MinimumSizeSubarraySum().MinimumSizeSubarraySum(sum,nums));
    }
}