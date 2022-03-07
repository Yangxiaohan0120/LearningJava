package LeetCodeII;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 4:42 PM
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        int res = 1;
        int end = intervals[0][1];


        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= end){
                res ++;
                end = intervals[i][1];
            }
        }

        return intervals.length - res;
    }

}