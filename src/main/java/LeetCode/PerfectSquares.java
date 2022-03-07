package LeetCode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ author: yxh
 * @ created: 2022-02-12 : 6:25 PM
 */
public class PerfectSquares {

    // 给出一个正整数n，寻找最少的完全平方数，使他们的和为n
    // 完全平方数：1，4，9，16
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(n, 0));

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            map.put(i, false);
        }

        while (!q.isEmpty()) {
            int num = q.peek().getKey();
            int step = q.peek().getValue();
            q.poll();

            for (int i = 1; num - i * i >= 0; i++) {
                int a = num -i*i;
                if(a < 0 )break;
                if(a == 0)return step+1;
                if (!map.get(a)) {
                    q.add(new Pair<>(a, step + 1));
                    map.put(a,true);
                }
            }
        }
        throw new IllegalArgumentException();
    }

    // 使用动态规划解决

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new PerfectSquares().numSquares(n));
    }
}