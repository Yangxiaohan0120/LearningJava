package LC;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 10:38 AM
 */
public class Combinations {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return res;
        List<Integer> p = new ArrayList<>();
        findCombinations(n, k, 1, p);
        return res;
    }

    private void findCombinations(int n, int k, int start, List<Integer> p) {
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }

        // 还有k - p.size 个元素。在[i ... n]中至少有（k-p.size)
        // i 最多为 n -（k-p.size) +1
        // 回溯法的剪枝，n-k+1 之后的数不可取
        for (int i = start; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            findCombinations(n, k, i + 1, p);// 递归调用 i 之后的数字
            p.remove(p.size() - 1); // 调用之后回溯，将此时的元素删除遍历下一个元素
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = new Combinations().combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                if (j != res.get(i).size() - 1) {
                    System.out.print(res.get(i).get(j) + "->");
                } else {
                    System.out.println(res.get(i).get(j));
                }
            }
        }
    }

}