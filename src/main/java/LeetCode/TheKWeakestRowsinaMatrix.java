package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Chris Yang
 * created 2022-04-07 21:32
 **/

// You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
// The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
//
// A row i is weaker than a row j if one of the following is true:
//
// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

public class TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        LinkedList list = new LinkedList();
        int[] res = new int[k];
        int index = 0;
        for (int j = 0; j < mat[0].length; j++) {
            if (index >= k) break;
            for (int i = 0; i < mat.length; i++) {
                if (index >= k) break;
                if (!list.contains(i) && mat[i][j] == 0) {
                    list.add(i);
                    res[index] = i;
                    index++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (!list.contains(i) && index < k) {
                list.add(i);
                res[index] = i;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0}, {1, 0}, {1, 0}, {1, 1}};
        int[] res = new TheKWeakestRowsinaMatrix().kWeakestRows(mat, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
