package 剑指Offer;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-08-02 08:51
 **/
public class ReversePairs {
    int count = 0;

    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        sort(nums, 0, nums.length - 1, temp);
        return count;
    }

    public void sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, temp);
        sort(nums, mid + 1, r, temp);

        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r, temp);
        }
    }

    public void merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                //tmp[i]~tmp[m]都大于tmp[j]
                nums[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new ReversePairs().reversePairs(nums));
    }
}
