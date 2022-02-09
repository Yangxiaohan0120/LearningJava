package Alibrary.sorting;

/**
 * @ author: yxh
 * @ created: 2021-12-16 : 10:50 PM
 */
public class SortingHelper {

    private SortingHelper() {

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {

        long startTime = System.nanoTime();
        if (sortname.equals("selectionSort"))
            SelectionSort.sort(arr);
        else if (sortname.equals("selectionSort2"))
            SelectionSort.sort2(arr);
        else if (sortname.equals("insertionSort"))
            InsertionSort.sort(arr);
        else if (sortname.equals("insertionSort2"))
            InsertionSort.sortreverse(arr);
        else if (sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if (sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if (sortname.equals("QuickSort2Ways"))
            QuickSort.sort2ways(arr);
        else if (sortname.equals("QuickSort3Ways"))
            QuickSort.sort3ways(arr);
        else if (sortname.equals("HeapSort"))
            HeapSort.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }

}