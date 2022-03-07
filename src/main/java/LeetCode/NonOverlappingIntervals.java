package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ author: yxh
 * @ created: 2022-02-15 : 2:06 PM
 */
public class NonOverlappingIntervals {

    // 给出一组区间，请问最少删除几个区间可以保证，区间之间相互不重叠
    // 起始值一定小于终止值，[1,2][2,3] 不算做重叠

    // 概念解析（最少删除 == 最多保留）


    // 动态规划
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1]; // -1不交换顺序，1交换顺序 （前面的值小于后面，不交换顺序）
                }else
                    return o1[0]-o2[0];
            }
        });

        int[] memo = new int[intervals.length];

        // 设置状态
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1; // 仅有本身的时候是互不重叠的
        }

        // 状态转移
        for (int i = 1; i < intervals.length; i++) {
            // 从i=1 开始
            for (int j = 0; j < i; j++) {
                // 对于所有之前的interval进行遍历
                // i是当前，j是之前，所以i的start要 >= j的end；
                if(intervals[i][0] >= intervals[j][1])
                    // 如果可以则数目加1；
                    memo[i] = Math.max(memo[i],1+memo[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res,memo[i]);
        }

        return intervals.length - res; // res是保留最多，那么相减就是删除最少
    }


    // 贪心算法
    // 按照结尾排序，使得结尾最早的区间优先进行选择
    public int eraseOverlapIntervals2(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0]; // -1不交换顺序，1交换顺序 （前面的值小于后面，不交换顺序）
                    // 结尾值越小排在前面
                }else
                    return o1[1]-o2[1];
            }
        });

        int res = 1; // 将结尾最早的排在最前面。
        int pre = 0; // 前一个区间的index 第一个区间为0
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= intervals[pre][1]){
                res ++;
                pre = i;
            }
        }

        return intervals.length - res;
    }


    public static void main(String[] args) {
        int[][] inters = {{1, 2}, {2, 3}, {1, 3}, {1, 5}, {2, 6}};
        Arrays.sort(inters);

        for (int i = 0; i < inters.length; i++) {
            System.out.println(inters[i][0] + "," + inters[i][1]);
        }
    }
}