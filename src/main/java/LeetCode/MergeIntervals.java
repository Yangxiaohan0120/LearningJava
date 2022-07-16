package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-06-15 01:07
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });


        List<int[]> result = new LinkedList();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end){
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                end = Math.max(end,intervals[i][1]);
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new MergeIntervals().merge(test);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }

    }
}
