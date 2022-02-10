package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-09 : 3:22 PM
 */


public class MinimumSizeSubarraySum {

    // 时间复杂度 O(n)
    // 空间复杂度 O(1)

    // 和大于阈值的最短连续子数组
    // 给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和sum >= s，返回这个最短的连续子数组的返回值。
    public int MinimumSizeSubarraySum(int s, int[] nums) {
        int l = 0, r = -1; //nums[l...r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length+1;

        while(l < nums.length){

            // 对于两个判断条件，第一个不满足即转为else（按顺序进行判断，不满足就跳转）
            if(r+1 < nums.length && sum < s) {
                sum += nums[++r];
                System.out.println("r: " + r);
            }else {
                sum -= nums[l++];
                System.out.println("l: " + l);
            }

            if(sum >= s)
                res = Math.max(res,r-l+1);
        }

        if(res == nums.length+1)
            return 0;
        return res;
    }

}