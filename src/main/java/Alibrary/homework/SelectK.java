package Alibrary.homework;

import Alibrary.sorting.QuickSort;
import Alibrary.utils.ArrayGenerator;

import java.util.Random;

/**
 * @ author: yxh
 * @ created: 2021-12-26 : 10:40 PM
 */
public class SelectK {

    //非递归实现
    public int findKthLargest(int[] nums, int k) {
        Random rnd = new Random();
        return selectK(nums, k, rnd);
    }

    public int selectK(int[] nums, int k, Random rnd) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int p = partition(nums, l, r, rnd);

            if (k == p) return nums[p];

            if (k < p) r = p - 1;
            else l = p + 1;
        }
        throw new RuntimeException("No Solution");
    }

    public int selectK2(int[] nums, int k, Random rnd) {
        int l = 0, r = nums.length;

        while (l < r) {

            int p = partition(nums, l, r, rnd);

            if (k == p) return nums[p];

            if (k < p) r = p;
            else l = p + 1;
        }
        throw new RuntimeException("No Solution");
    }

    //递归实现
    public int findKthLargestR(int[] nums, int k) {

        Random rnd = new Random();
        return selectKR(nums, 0, nums.length - 1, nums.length - k, rnd);
    }

    private int selectKR(int[] arr, int l, int r, int k, Random rnd) {

        int p = partition(arr, l, r, rnd);

        if (k == p) return arr[p];

        if (k < p) return selectKR(arr, l, p - 1, k, rnd);
        return selectKR(arr, p + 1, r, k, rnd);
    }

    private int partition(int[] arr, int l, int r, Random rnd) {

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i] < arr[l])
                i++;

            while (j >= i && arr[j] > arr[l])
                j--;

            if (i >= j) break;

            swap(arr, i, j);

            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;
        int k = 40;
        int[] nums = ArrayGenerator.generateRandomArrayint(n, n);

        SelectK sk = new SelectK();
        System.out.println(sk.findKthLargestR(nums, 40));
    }
}