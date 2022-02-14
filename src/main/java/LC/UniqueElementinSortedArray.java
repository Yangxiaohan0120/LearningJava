package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 6:16 PM
 */
public class UniqueElementinSortedArray {

    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int l, int r) {
        while(l < r) {
            int n = l + (r-l)/2;
            if(nums[n] == nums[n^1]){
                l = n+1;
            }else {
                r = n;
            }
        }

        return nums[l];
    }

}