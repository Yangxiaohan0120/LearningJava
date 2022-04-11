package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-04-10 14:49
 **/
public class Triangle01 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        memo[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + cur;
                } else if (j == triangle.get(i).size()-1) {
                    memo[i][j] = memo[i - 1][j - 1] + cur;
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j - 1] + cur, memo[i - 1][j] + cur);

                }
            }
        }
        int min = Integer.MAX_VALUE;
        int n = triangle.size();
        for (int i = 0; i < memo[n - 1].length; i++) {
            min = Math.min(memo[n - 1][i], min);
        }

        return min;

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        list.add(list1);
        list.add(list2);
        list.add(list3);


        int res = new Triangle01().minimumTotal(list);
        System.out.println(res);
    }
}
