package LCII;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:13 PM
 */
public class FourSumII {

    // A B C D 寻找有多少的i j k l 的组合使得nums1[i]+nums2[j]+C[k]+D[l] == 0, 其中元素个数都为N，0<=N<=500

    // 解决，将C+D的结果放入查找表中（共有250000）
    public int FourSumII(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> CDMap = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (CDMap.containsKey(nums3[i] + nums4[j])) {
                    CDMap.put(nums3[i] + nums4[j], CDMap.get(nums3[i] + nums4[j]) + 1);
                } else {
                    CDMap.put(nums3[i] + nums4[j], 1);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (CDMap.containsKey(0 - nums1[i] - nums2[j])) {
                    res += CDMap.get(0 - nums1[i] - nums2[j]);
                }
            }
        }

        return res;
    }

}