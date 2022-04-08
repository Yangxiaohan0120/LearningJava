package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-07 20:57
 **/

// Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

public class CountNegativeNumberSortedMatrix {
    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = 0;

        int m = grid.length;
        int n = grid[0].length;

        while (i < m) {
            if (grid[i][0] >= 0) {
                i++;
            } else break;
        }

        i--;
        int count = 0;
        while (i >= 0) {
            while (j < n && grid[i][j] >= 0) {
                j++;
            }
            count += j;
            i--;
        }

        return m * n - count;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, 1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int count = new CountNegativeNumberSortedMatrix().countNegatives(grid);
        System.out.println(count);
    }
}
