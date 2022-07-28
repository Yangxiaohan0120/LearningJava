package 剑指Offer;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-07-28 19:25
 **/
public class SmallestKNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSearch(int[] arr, int l, int r, int k) {
        int j = partition(arr, l, r);
        if (j == k) {
            return Arrays.copyOfRange(arr, 0, j + 1);
        }
        return j > k ? quickSearch(arr, l, j - 1, k) : quickSearch(arr, j + 1, r, k);
    }

    public int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l, j = r + 1;
        while (true) {
            while (j-- >= l && arr[j] > v) ;
            while (i++ <= r && arr[i] < v) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        return i;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1};
        int[] res = new SmallestKNumbers().getLeastNumbers(nums, 1);
        System.out.println(res[0]);
    }
}
