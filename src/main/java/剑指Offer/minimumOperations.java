package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-08-02 12:37
 **/
public class minimumOperations {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(new minimumOperations().minimumOperations(nums));
    }
}
