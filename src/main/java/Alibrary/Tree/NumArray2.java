package Alibrary.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 3:29 PM
 */
public class NumArray2 {

    private int[] sum; // sum[i] 存储前i个元素的和

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}