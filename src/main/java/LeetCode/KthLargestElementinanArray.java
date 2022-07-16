package LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Chris Yang
 * created 2022-07-14 16:23
 **/
public class KthLargestElementinanArray {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    // 使用QuickSort选到k
    public int quickSelection(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelection(nums, q + 1, r, index) : quickSelection(nums, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, l, i);
        return Partition(nums, l, r);
    }

    private int Partition(int[] nums, int l, int r) {
        int x = nums[l];
        int index = l + 1;
        for (int i = index; i <= r; i++) {
            if (nums[i] < x) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index - 1, l);
        return index - 1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 使用堆排序找到k


    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() ; i ++){
            if(s.charAt(i) == ' '){
                sb.append('%');
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums, k));
    }
}
