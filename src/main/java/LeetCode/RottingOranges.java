package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chris Yang
 * created 2022-04-07 15:24
 **/

//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


// 2(坏掉的) 感染 1(新鲜的) 橘子，但是0 没有橘子
// 每分钟都感染周围的橘子
// 若还有就返回-1


public class RottingOranges {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Deque<Integer[]> deque = new ArrayDeque<>();

        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new Integer[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int cost = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int s = 0; s < size; s++) {
                Integer[] cur = deque.pop();

                int i = cur[0];
                int j = cur[1];

                if (grid[i][j] == 2) {
                    res[i][j] = cost;
                }

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        if (grid[x][y] == 2 || grid[x][y] == 0) {
                            continue;
                        } else {
                            deque.add(new Integer[]{x, y});
                            freshCount--;
                        }
                    }
                }
            }

            if (!deque.isEmpty()) {
                cost++;
            }
        }

        if (freshCount != 0) {
            return -1;
        } else return cost;

    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = new RottingOranges().orangesRotting(grid);
        System.out.println(res);
    }
}
