package LCII;

import java.util.TreeSet;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:47 PM
 */
public class ContainsDuplicateIII {

    // nums[] 是否存在i,j 满足nums[i]和nums[j]差别不超过t,  i,j差别不超过k

    public boolean ContainsDuplicateIII(int[] nums, int k, int t) {
        TreeSet<Integer> existSet = new TreeSet<>();


        // |----------------| (     nums[i]     ) |----------------------|
        // 核心找到一个值在 nums[i] 的包围圈里面
        // 找到数组中最靠近右边界的值，看是否大于左边界
        // 找到数组中最靠近左边界的值，看是否小于右边界

        //ceiling the least key greater than or equal to key, 大于等于某个值的最小值，左边界
        //floor the greatest key less than or equal to key, 小于等于某个值的最大值，右边界
        for (int i = 0; i < nums.length; i++) {
            if(existSet.ceiling(nums[i] - t ) != null && existSet.ceiling(nums[i] - t) <= nums[i] + t){
                return true;
            }else existSet.add(nums[i]);

            if(existSet.size() == k+1)
                existSet.remove(nums[i-k]);
        }

        return false;
    }

}