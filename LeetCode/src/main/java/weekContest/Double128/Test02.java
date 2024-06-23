package weekContest.Double128;

import java.util.Arrays;

public class Test02 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] nums = Arrays.stream(points).mapToInt(p -> p[0]).toArray();
        Arrays.sort(nums);
        int res = 1; int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > a + w){
                res += 1;
                a = nums[i];
            }
        }
        return res;
    }

    public void test(){
        int[][] group = {{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};
        int w = 1;
        int res = minRectanglesToCoverPoints(group,w);
        System.out.println(res);

        int[][] group1 = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}};
        w = 2;
        res = minRectanglesToCoverPoints(group,w);
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Test02().test();
    }
}
