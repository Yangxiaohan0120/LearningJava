package LeetCodeII;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 10:38 AM
 */
public class PerfectSquares {

    // 给出一个正整数n，寻找最少的完全平方数，使他们的和为n
    // 完全平方数：1，4，9，16
    public int numSquares(int n) {

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(n,0));
        Map<Integer,Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i,false);
        }

        while(q.isEmpty()) {
            int number = q.peek().getKey();
            int step = q.peek().getValue();
            q.poll();

            for (int i = 1; i * i <= number; i++) {
                int a = number - i*i;
                if(a <0)break;
                if(a == 0)return step+1;
                if(!map.get(a)) {
                    // 之前没出现过的，如果之前就出现过，这次的step肯定是比原来大于等于的，所以没必要计算。
                    q.add(new Pair<>(a, step + 1));
                    map.put(a,true);
                }
            }
        }

        throw new ArithmeticException();
    }

}