package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 12:36 PM
 */

// FloodFill 算法

// 1代表岛屿，2代表海水
public class NumberofIslands {

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m > 0) {
            n = grid[0].length;
        }
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    res++;
                    findIsland(grid, i, j);
                }
            }
        }

        return res;
    }

    private void findIsland(char[][] grid, int startx, int starty) {
        visited[startx][starty] = true;
        for (int i = 0; i < 4; i++) {
            int newx = startx + directions[i][0];
            int newy = starty + directions[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                findIsland(grid, newx, newy);
            }
        }

        return ;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}