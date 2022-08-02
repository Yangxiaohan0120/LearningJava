package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-02 09:49
 **/
public class MissingDigitinSortedArray {
    public int missingNumber(int[] nums) {
        int[] res = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]] = 1;
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 0)return i;
        }
        return -1;
    }
}
