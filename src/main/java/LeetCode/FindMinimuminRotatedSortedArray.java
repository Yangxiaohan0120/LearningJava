package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-14 22:03
 **/
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int min = new FindMinimuminRotatedSortedArray().findMin(nums);
        System.out.println(min);
    }
}
