package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:20 PM
 */
public class HouseRobber {

    // f(x) 状态： 代表着考虑偷取[x...n-1]的最大值（x不一定偷取）
    // f(0) = max{v(0) + f(2), v(1) + f(3), v(2) + f(4), ... ,v(n-3)+f(n-1), v(n-2),v(n-1)}

    // f(x) 状态： 代表着考虑偷取[0...x]的最大值（x不一定偷取）



    public int rob(int[] nums){
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }

        int n = nums.length;
        memo[nums.length-1] = nums[nums.length-1];

        for (int i = nums.length-2; i >= 0 ; i--) {
            // 更新
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i],nums[j] + (j+2 < n ? memo[j+2] : 0));
            }
        }

        return memo[0];
    }

}