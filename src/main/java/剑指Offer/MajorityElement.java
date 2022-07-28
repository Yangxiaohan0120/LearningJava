package 剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-07-28 19:17
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.keySet().contains(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer n : map.keySet()) {
            if (map.get(n) > nums.length / 2) {
                return n;
            }
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
