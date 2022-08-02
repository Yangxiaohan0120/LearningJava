package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-02 09:25
 **/
public class SearchinSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int right = l;
        if (r >= 0 && nums[r] != target) return 0;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int left = r;
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums1 = new int[0];
        System.out.println(new SearchinSortedArray().search(nums, 8));
    }
}
