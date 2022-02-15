package LC;

import Alibrary.Linear.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @ author: yxh
 * @ created: 2022-02-15 : 1:40 PM
 */
public class AssignCookies {

    // 给定数组s(i) 和 g(i) , s代表的是饼干带来的开心值，g代表的是小朋友需要开心的阈值，如果s(j) >= g(i), !!! 每个孩子最多给一个
    // 那么将j的饼干给i的小朋友，小朋友就得到了满足，请问如何分配使得更多的小朋友满意 （更多？相对最优解，而不是绝对最优解）

    // 比如 s = [1,1]  g = [1,2,3] 结果为1
    // 比如 s = [1,2,3] g = [1,2] 结果为2

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s); // nlogn
        Arrays.sort(g); // nlogn

        int si = s.length - 1;
        int gi = g.length - 1;
        int res = 0;

        // n
        while(si >= 0 && gi >= 0){
            if(s[si] >= g[gi]){
                res ++;
                gi --;
                si --;
            }else {
                gi --;
            }
        }

        return res;
    }



}