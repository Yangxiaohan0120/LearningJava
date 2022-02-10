package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-09 : 2:40 PM
 */
public class MoveZeros {

    public void moveZeros1(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[k++]= nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeros2(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                if(i != k) {
                    swap(nums, k++, i);
                }else
                    k++;
            }
        }
    }

    private void swap(int[] nums ,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}