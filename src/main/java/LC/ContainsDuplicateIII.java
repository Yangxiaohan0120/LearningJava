package LC;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 1:40 PM
 */
public class ContainsDuplicateIII {


    // nums[] 是否存在i,j 满足nums[i]和nums[j]差别不超过t,  i,j差别不超过k

    public boolean ContainsDuplicateIII(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // 是否存在小于上边界的值，并且这个值还要大于下边界
            // floor(小于等于这个值的最大值）ceiling() 也可以解决，大于等于这个值的最小值


            if (record.floor( (long)nums[i] + (long) t) != null && record.floor((long) nums[i] + (long) t) >= (long) nums[i] - (long) t) {
                return true;
            } else {
                record.add((long)nums[i]);
            }

            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}