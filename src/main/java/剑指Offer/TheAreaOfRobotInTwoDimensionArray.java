package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 15:39
 **/
public class TheAreaOfRobotInTwoDimensionArray {
    int count = 0;
    boolean[][] visited;
    int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int movingCount(int m, int n, int k) {
        int i = 0;
        int j = 0;
        visited = new boolean[m][n];
        dfs(i, j, m, n, k);
        return count;
    }

    public void dfs(int x, int y, int m, int n, int k) {
        if (inArea(x, y, m, n) && !visited[x][y] && Count(x) + Count(y) <= k) {
            visited[x][y] = true;
            count++;
            for (int i = 0; i < direction.length; i++) {
                dfs(x + direction[i][0], y + direction[i][1], m, n, k);
            }
        } else {
            return;
        }
    }

    public boolean inArea(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        } else {
            return false;
        }
    }

    public int Count(int n) {
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n = n / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new TheAreaOfRobotInTwoDimensionArray().Count(100));
        int res = new TheAreaOfRobotInTwoDimensionArray().movingCount(16, 8, 4);
        System.out.println(res);
    }
}
