package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-07-22 11:09
 **/
public class DuplicateNumberinArrays {
    // 数组
    public int findRepeatNumber(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            res[nums[i]]++;
        }
        for(int i = 0; i < res.length;i++){
            if(res[i] > 1){
                return i;
            }
        }
        return -1;
    }

    // 排序
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    // 哈希
    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i])){
                return(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,3,5};
        int res = new DuplicateNumberinArrays().findRepeatNumber(nums);
        System.out.println(res);
    }
}
