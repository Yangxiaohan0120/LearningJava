package 剑指Offer;

import DataStructureAndAlgorithm.Linear.array.Array;
import com.beust.ah.A;

import java.util.ArrayList;

/**
 * @author Chris Yang
 * created 2022-08-01 11:07
 **/
public class MaxArray {
    int m, n;
    int max = 0;

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        res[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            res[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                res[j] = Math.max(res[j-1] + grid[i][j], res[j] + grid[i][j]);
            }
        }
        return res[n-1];
    }

    public void dfs(int[][] grid, int l, int r, int value) {

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MaxArray().maxValue(grid));
    }
}
