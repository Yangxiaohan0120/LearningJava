package Alibrary.sorting;

import Alibrary.utils.ArrayGenerator;

/**
 * @ author: yxh
 * @ created: 2021-12-26 : 11:55 AM
 */
public class InsertionSort {

    private InsertionSort() {

    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    //更一般的insertionSort（局部排序）
    public static <E extends Comparable<E>> void insertionSort(E[] arr,int l,int r) {
        for (int i = l; i <= r; i++) {
            E t = arr[i];
            int j;
            for (j = i; j -1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sortreverse(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSort", arr);
        }
    }
}