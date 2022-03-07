package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 4:37 PM
 */
public class HouseRobber {

    int[] memo;

    // f(x) 状态： 代表着考虑偷取[x...n-1]的最大值（x不一定偷取）
    // f(0) = max{v(0) + f(2), v(1) + f(3), v(2) + f(4), ... ,v(n-3)+f(n-1), v(n-2),v(n-1)}

    // f(x) 状态： 代表着考虑偷取[0...x]的最大值（x不一定偷取）
    //

    // 暴力遍历求解
    public int rob(int[] nums) {
        return tryRob(nums,0);
    }

    private int tryRob(int[] nums,int index){
        if(index >= nums.length)return 0;

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = nums[i] + tryRob(nums,i+2);
        }

        return res;
    }


    // 记忆化搜索的方式
    public int rob2(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;
        memo = new int[n];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        memo[n -1] = nums[n-1];


        for (int i = n-2; i >= 0 ; i--) {
            // 求解memo[i]
            // f(0) = max{v(0) + f(2), v(1) + f(3), v(2) + f(4), ... ,v(n-3)+f(n-1), v(n-2),v(n-1)}
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i],nums[j]+(j+2 < n ? memo[j+2] : 0));
                // 每次添加新房子都更新
            }
        }

        return memo[0];
    }

    private int tryRob2(int[] nums,int index){
        if(index >= nums.length)return 0;

        if(memo[index] != -1){
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = nums[i] + tryRob(nums,i+2);
        }
        memo[index] = res; //记录值

        return res;
    }

    // 动态规划
}