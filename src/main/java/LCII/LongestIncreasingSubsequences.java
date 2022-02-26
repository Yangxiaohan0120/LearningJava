package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 3:33 PM
 */
public class LongestIncreasingSubsequences {

    // 最长上升子序列
    // LIS[i] 代表以i个数字结尾的最长上升子序列的长度 // 状态定义
    // LIS[i] = max(1+LIS[j] (if nums[i] > nums[j])) j < i

    public int lengthOfLIS(int[] nums) {
        int memo[] = new int[nums.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }

        int res = 1;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] >= nums[j]){
                    memo[i] = Math.max(memo[i],1+memo[j]);
                }
            }
            if(res > memo[i]) res = memo[i];
        }

        return res;
    }

}