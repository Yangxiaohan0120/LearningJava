package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-26 22:11
 **/
public class OddEven {
    public int[] exchange(int[] nums) {
        if(nums.length == 0)return nums;
        int i = 0,j=nums.length-1;
        while(i < j){
            if(nums[i] % 2 == 0 && nums[j] % 2 == 1){
                swap(nums,i,j);
            }else if(nums[j] % 2 == 0){
                j--;
            }else {
                i++;
            }
        }
        return nums;
    }

    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,6,2,5,4,0,12,43};
        int[] res = new OddEven().exchange(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
