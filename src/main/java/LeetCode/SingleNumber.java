package LeetCode;

import java.util.HashMap;

/**
 * @author Chris Yang
 * created 2022-04-10 15:19
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int res = 0;
        for (int key : map.keySet()) {
            if(map.get(key) == 1){
                res = key;
                break;
            }
        }

        return res;
    }
}
