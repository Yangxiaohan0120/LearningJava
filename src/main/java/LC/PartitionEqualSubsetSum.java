package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-15 : 12:39 PM
 */
public class PartitionEqualSubsetSum {

    // 将数组分成两个子集，使得两个部分的元素和相等。

    int[][] memos; // index 列，c中 容量
    // memo[i][c] 使用[0...i]的元素是否可以填充容量为c的背包

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;

        memos = new int[nums.length][sum/2+1];
        for (int i = 0; i < memos.length; i++) {
            for (int j = 0; j < memos.length; j++) {
                memos[i][j] = -1;
            }
        }

        return tryPartition(nums, nums.length - 1, sum / 2);

    }

    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) return true;

        if (index < 0 || sum < 0) return false;

        if(memos[index][sum] != -1)
            return memos[index][sum] == 1;

        memos[index][sum] = (tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index])) ? 1 : -1;

        return memos[index][sum] == 1;
    }

    public boolean canPartition2(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 == 1)return false;

        int n = nums.length;
        int C = sum/2;

        boolean[] memos = new boolean[C+1];
        for (int i = 0; i < memos.length; i++) {
            memos[i] = false;
        }

        // nums[] = {2,1,2}
        // ---------------------------------------------------
        // |  n\C  |   0   |  1   |   2   |   3  | ...  | C  |
        // |   1   |   -1  |  -1  |   1   |  -1  | ...  | -1 |
        // 只放入第一个东西是否能够填满背包
        for (int i = 0; i <= C ; i++) {
            memos[i] = (nums[0] == i);
        }

        // ---------------------------------------------------
        // |  n\C  |   0   |  1   |   2   |   3  | ...  | C  |
        // |   1   |   -1  |  -1  |   1   |  -1  | ...  | -1 |
        // |   2   |   -1  |  1   |   1   |   1  | ...  | -1 |
        // |   3   |       |      |       |      | ...  |    |
        // |   4   |       |      |       |      | ...  |    |
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i] ; j--) {
                // 倒着从最大值看什么时候能填充完
                memos[j] = memos[j] || memos[j - nums[i]];
                // memos[j] 仅用当前的元素即可填充满
                // memos[j - nums[i]] 减去当前元素，之前的元素就可以填充满
            }
        }

        return memos[C];
        // C = sum/2 返回这些物品是否可以填充满容量为C的背包，即题目的问题
    }

    public static void main(String[] args) {
        int[] nums = {10,5,5,1,5};
        boolean res = new PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(res);
    }

}