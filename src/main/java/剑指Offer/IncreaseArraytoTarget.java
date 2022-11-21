package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-08-04 19:29
 **/
public class IncreaseArraytoTarget {
    public int[][] findContinuousSequence(int target) {
        int[] nums = new int[target / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int i = 0, j = 1;
        List<int[]> list = new ArrayList<>();
        int sum = nums[i] + nums[j];
        while (i < j && j < nums.length) {
            if (sum == target) {
                list.add(Arrays.copyOfRange(nums, i, j+1));
                sum -= nums[i];
                i++;
            } else if (sum < target) {
                j++;
                sum += nums[j];
            } else {
                sum -= nums[i];
                i++;
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] res = new IncreaseArraytoTarget().findContinuousSequence(15);
        System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
