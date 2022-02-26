package LCII;

import java.util.HashSet;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:41 PM
 */
public class ContainsDuplicateII {

    // nums[],k  是否存在i,j 满足nums[i] == nums[j] 并且i,j之间不超过k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> existSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(existSet.contains(nums[i]))return true;
            existSet.add(nums[i]);

            if(existSet.size() == k+1){
                existSet.remove(nums[i-k]);
            }
        }

        return false;
    }

}