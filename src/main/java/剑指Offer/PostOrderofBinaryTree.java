package 剑指Offer;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-07-27 23:06
 **/
public class PostOrderofBinaryTree {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int root = postorder[right];
        int midIndex = left;
        while (postorder[midIndex] < root) {
            midIndex++;
        }
        for (int i = midIndex + 1; i < postorder.length - 1; i++) {
            if (postorder[i] < root) return false;
        }
        return verify(postorder, left, midIndex - 1) && verify(postorder, midIndex, right - 1);

    }
}
