package LeetCode;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-04-07 21:49
 **/

// 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足：
//
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
//

public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]))return true;
            set.add(arr[i]*2);
            if(arr[i] % 2 ==0){
                set.add(arr[i]/2);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,7,12};
        boolean res = new CheckIfNandItsDoubleExist().checkIfExist(arr);
        System.out.println(res);

    }
}
