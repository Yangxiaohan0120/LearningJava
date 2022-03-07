package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 10:30 PM
 */
public class LongestIncreasingSubsequences {

    int[] memo;
    // 最长上升子序列
    // LIS[i] 代表以i个数字结尾的最长上升子序列的长度 // 状态定义
    // LIS[i] = max(1+LIS[j] (if nums[i] > nums[j])) j < i
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
        }
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) memo[i] = Math.max(memo[i], memo[j] + 1);
            }
            if (memo[i] > result) result = memo[i]; // 更新result的值
        }

        return result;
    }

}