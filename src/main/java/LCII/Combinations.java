package LCII;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 1:18 PM
 */
public class Combinations {

    List<List<Integer>> res;
    // Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
    // You may return the answer in any order.
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n == 0 || k > n ) return res;
        List<Integer> p = new ArrayList<>();
        getCombinations(n,k,1,p);
        return res;
    }

    private void getCombinations(int n, int k, int index,List<Integer> p){
        if(p.size() == k){
            res.add(new ArrayList<>(p));
            return;
        }

        // 不断调用
        for (int i = index; i <= n ; i++) {
            p.add(i);
            getCombinations(n,k,i+1,p);
            p.remove(p.size()-1);
        }
    }

}