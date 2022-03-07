package DataStructureAndAlgorithm.sorting;

import DataStructureAndAlgorithm.utils.ArrayGenerator;

/**
 * @ author: yxh
 * @ created: 2021-12-26 : 11:52 AM
 */
public class SelectionSort {

    private SelectionSort() {

    }

    private static <E> void swap(E[] array, int index1, int index2) {
        E t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(array, i, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}