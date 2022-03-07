package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-09 : 2:39 PM
 */
public class LCStart {

    public static void main(String[] args) {
        testMethod();
    }

    private static void testMethod(){
        int[] nums = {1,0,3,0,12};

        long startTime = System.nanoTime();
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        m.MinimumSizeSubarraySum(4,nums);
        long endTime = System.nanoTime();
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
        System.out.println("Runs for " + (double) (endTime - startTime) / 1000000 + " ms.");
    }

}