package LeetCodeII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 4:41 PM
 */
public class MoveZeros {

    public void moveZeros(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}