package 剑指Offer;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Chris Yang
 * created 2022-08-04 20:15
 **/
public class MaximumNumberofSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.peek();
            queue.remove(nums[i]);
            if(i+k<nums.length) {
                queue.add(nums[i + k]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = new MaximumNumberofSlidingWindow().maxSlidingWindow(nums,3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
