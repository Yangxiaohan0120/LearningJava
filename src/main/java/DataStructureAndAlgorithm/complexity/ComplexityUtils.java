package DataStructureAndAlgorithm.complexity;

import DataStructureAndAlgorithm.searching.BinarySearch;
import DataStructureAndAlgorithm.utils.ArrayGenerator;

/**
 * @ author: yxh
 * @ created: 2022-02-08 : 8:22 PM
 */

/*
    算法复杂度的分析
 */

public class ComplexityUtils {

    public static void main(String[] args) {

        for (int i = 10; i < 26; i++) {

            int n = (int) Math.pow(2,i);
            Integer[] arr = ArrayGenerator.generateRandomArray(n,100000000);

            long startTime = System.nanoTime();
            BinarySearch.search(arr,1000);// 任意想要测试的代码
            long endTime = System.nanoTime();

            System.out.println("data size 2^"+i+" = "+n+", Time cost : "+(double)(endTime-startTime)/1000000+" ms.");
        }
    }

}