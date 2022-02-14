package LC;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 12:15 PM
 */
public class WordSearch {

    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 偏移量数组
    int m, n;
    boolean[][] visited;

    // 在二维单词组中查找单词（不可重复）
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m > 0) {
            n = board[0].length;
        }

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(findWord(board, word,0, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean findWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1)
            return word.charAt(index) == board[startx][starty];

        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + direction[i][0];
                int newy = starty + direction[i][1];
                if (inArea(newx, newy) && visited[newx][newy] == false) {
                    if(findWord(board, word, index + 1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }

        return false;
    }

}