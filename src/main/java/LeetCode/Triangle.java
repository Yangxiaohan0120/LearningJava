package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 2:58 PM
 */

// 给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
// 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

// Exceed limit

public class Triangle {
    private int res;

    public int minimumTotal(List<List<Integer>> triangle) {
        int index = 0;
        res = triangle.get(0).get(0);
        List<Integer> reslist = new ArrayList<>();
        getNumbers(triangle, 1, index, reslist);
        int Min = Integer.MAX_VALUE;
        for (int i = 0; i < reslist.size(); i++) {
            Min = Math.min(Min, reslist.get(i));
        }

        return Min;
    }

    public void getNumbers(List<List<Integer>> list, int size, int index, List<Integer> reslist) {
        if (size == list.size()) {
            reslist.add(res);
            return;
        }

        res += list.get(size).get(index);
        getNumbers(list, size + 1, index, reslist);
        res -= list.get(size).get(index);
        res += list.get(size).get(index + 1);
        getNumbers(list, size + 1, index+1, reslist);
        res -= list.get(size).get(index + 1);
    }

    public static void main(String[] args) {
//        List<List<Integer>> triangle = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        List<Integer> l3 = new ArrayList<>();
//        List<Integer> l4 = new ArrayList<>();
//        l1.add(2);
//        l2.add(3);
//        l2.add(4);
//        l3.add(6);
//        l3.add(5);
//        l3.add(7);
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);
//        triangle.add(l1);
//        triangle.add(l2);
//        triangle.add(l3);
//        triangle.add(l4);


        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        list.add(list1);
        list.add(list2);
        list.add(list3);


        int res = new Triangle().minimumTotal(list);
        System.out.println(res);
    }

}