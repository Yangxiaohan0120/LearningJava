package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-02 09:53
 **/
public class MatchstickstoSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }

        int len = sum / 4;

        if (sum == 0 || sum % 4 != 0) return false;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = {0, 0, 0, 0};
        return dfs(sides, matchsticks, 0, len);

    }

    public boolean dfs(int[] sides, int[] nums, int index, int len) {
        // 到达终点，说明全部安排好了，返回真
        if (index == nums.length) {
            return true;
        }

        // 现在处理的火柴
        int curr = nums[index];

        // 尝试将这个火柴加到四条边中
        for (int i = 0; i < 4; i++) {
            if (i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }
            // 如果加的进去
            if (sides[i] + curr <= len) {
                sides[i] += curr;
                // 加下一根，看是否成功
                if (dfs(sides, nums, index + 1, len)) {
                    return true;
                }
                // 如果没返回成功，那么就把这条取消，加入下一个
                sides[i] -= curr;
            }
        }
        return false;
    }

    public void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int temp = 0;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
