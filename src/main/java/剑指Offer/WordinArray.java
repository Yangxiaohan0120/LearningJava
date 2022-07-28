package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-27 19:55
 **/
public class WordinArray {

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            System.out.println(i);
            for (int j = 0; j < n; j++) {
                System.out.println(j);
                if (isMatch(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean isMatch(char[][] board, String word, int x, int y, int index) {
        if (board[x][y] != word.charAt(index)) return false;
        if (index == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean res = false;
        for (int i = 0; i < direction.length; i++) {
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if (inArea(m, n, newx, newy) && !visited[newx][newy]) {
                res = res || isMatch(board, word, newx, newy, index + 1);
            }
        }
        visited[x][y] = false;
        return res;
    }

    public boolean inArea(int m, int n, int x, int y) {
        if (x >= 0 && y >= 0 && x < m && y < n) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(new WordinArray().exist(board, word));
    }
}
