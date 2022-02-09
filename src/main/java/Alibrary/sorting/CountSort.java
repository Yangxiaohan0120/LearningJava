package Alibrary.sorting;

/**
 * @ author: yxh
 * @ created: 2022-01-29 : 9:59 PM
 */
public class CountSort {

    private CountSort() {

    }

    public void sort(int[] nums){
        int R = 3;

        int[] cnt = new int[R];

        for(int num : nums){
            cnt[num] ++;
        }

        int[] index = new int[R +1];
        for (int i = 0; i < R; i++) {
            index[i+1] = index[i] + cnt[i];
        }

        for (int i = 0; i + 1 < index.length; i++) {
            for (int j = index[i]; j < index[i+1] ; j++) {
                nums[j] = i;
            }
        }
    }


}