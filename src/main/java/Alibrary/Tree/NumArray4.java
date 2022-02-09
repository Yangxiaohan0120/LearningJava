package Alibrary.Tree;

/**
 * @ decription using segmentTree to sumRange without TLE;
 * @ author: yxh
 * @ created: 2022-01-17 : 11:50 AM
 */
public class NumArray4 {

    private SegmentTree<Integer> segmentTree;

    public NumArray4(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
            //接受两个参数a,b 并返回a+b
            //(parameters) -> expression lambda表达式，代替了merger
        }
    }

    public void update(int index, int val) {
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");

        return segmentTree.query(i, j);
    }

}