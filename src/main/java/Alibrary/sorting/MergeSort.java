package Alibrary.sorting;

import Alibrary.utils.ArrayGenerator;

import java.util.Arrays;

/**
 * @ author: yxh
 * @ created: 2021-12-26 : 11:59 AM
 */
public class MergeSort {

    private MergeSort(String[] args) {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;

        //当n较小的时候insertSort快于mergeSort
//        if(r-l<=15){
//            InsertionSort.insertionSort(arr,l,r);
//            return;
//        }
//        int mid = (l + r) / 2;
        //l+r可能会溢出
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);
    }

    //bottom up 自底向上 ！！！！（多理解）
    public static <E extends Comparable<E>> void sortBU(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;

        for (int sz = 1; sz < n; sz += sz) {
            //遍历合并两个区间的起始位置
            //合并[i,i+sz-1]和[i+sz,Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    //temp在开始时就拷贝传递，而不反复的拷贝。
    public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        //将arr的从l起拷贝到temp从l起，拷贝长度r-l+1
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        //为arr[k]重新赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    //后修改为temp开始时生成
    public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        //为arr[k]重新赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }


    public static <E extends Comparable<E>> void MymergeSort(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        MymergeSort(arr, l, mid);
        MymergeSort(arr, mid + 1, r);
        Mymerge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void Mymerge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = 0;
        int j = mid + 1 - l;

        int k = l;

        while (i <= (mid - l) && j <= (r - l)) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= (mid - l)) {
            arr[k++] = temp[i++];
        }
        while (j <= (r - l)) {
            arr[k++] = temp[j++];
        }
    }


    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("MergeSort", arr);
    }
}