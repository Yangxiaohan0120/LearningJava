package DataStructureAndAlgorithm.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 3:20 PM
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
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

    public int sumRange(int i, int j) {
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null");

        return segmentTree.query(i, j);
    }
}