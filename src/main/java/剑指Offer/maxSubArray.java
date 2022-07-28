package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-28 20:16
 **/
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int former = 0;
        int cur = nums[0];//用于记录dp[i]的值
        for(int num:nums){
            cur = num;
            if(former>0) cur +=former;
            if(cur>max) max = cur;
            former=cur;
        }
        return max;
    }
}
