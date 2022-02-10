package LC;

import Alibrary.utils.ArrayGenerator;

/**
 * @ author: yxh
 * @ created: 2022-02-09 : 3:01 PM
 */
public class SortColors {


    // nums[0...zero] == 0 ,nums[zero+1...i] == 1, nums[i...two-1] == ? ,nums[two...n-1] == 2
    public void SortColors() {
        int[] nums = ArrayGenerator.generateRandomArrayint(1000, 1000);
        // 初始时是无效数组
        int zero = -1; // nums[0...zero] == 0
        int two = nums.length; // nums[two...n-1] == 2;
        //
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two --;
                swap(nums,i,two);
            }else {
                zero ++;
                swap(nums,zero,i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}