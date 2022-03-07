package LeetCode;

import java.util.HashSet;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 1:23 PM
 */
public class ContainsDuplicateII {


    // nums[],k  是否存在i,j 满足nums[i] == nums[j] 并且i,j之间不超过k
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> record = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(record.contains(nums[i])){
                return true;
            }else {
                record.add(nums[i]);
            }

            if(record.size() == k+1){
                record.remove(nums[i-k]);
            }
        }
        return false;
    }

}