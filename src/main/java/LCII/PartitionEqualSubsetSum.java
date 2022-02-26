package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 9:46 AM
 */
public class PartitionEqualSubsetSum {

    // 将数组分成两个子集，使得两个部分的元素和相等。

    int[][] memos; // index 列，c中 容量
    // memo[i][c] 使用[0...i]的元素是否可以填充容量为c的背包

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        int C = sum/2;

        boolean[] memo = new boolean[C+1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = false;
        }

        for (int i = 0; i <= C; i++) {
            memo[i] = (nums[0] == i);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = C; j >= nums[i] ; j--) {
                // 更新每一行，加入或者不加入新的元素，是否能填满[0...C]
                memo[j] = memo[j] || memo[j - nums[i]];
                // memo[j] 原来nums[0] 就可以填满 C==j
                // memo[j - nums[i]]   C==j-nums[i] 不填当前的物品
            }
        }

        return memo[C];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3,2,1};

        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }



}