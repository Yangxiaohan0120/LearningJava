package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-14 21:45
 **/
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // l < mid 不跨过0点（最小值）
            if(nums[l] <= nums[mid]) {

                // target在非0的区间
                if(nums[l] <= target && target < nums[mid]) {
                    r=mid-1;
                }
                // target不在非0的区间
                else {
                    l=mid+1;
                }
            }
            // mid -- r 不跨过0点（最小值）
            else {

                // target在右侧的非0区间
                if(nums[mid] < target && target <= nums[r]) {
                    l=mid+1;
                }

                // target不在右侧的非0区间
                else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 5;
        int index = new SearchinRotatedSortedArray().search(nums, target);
        System.out.println(index);
    }
}
