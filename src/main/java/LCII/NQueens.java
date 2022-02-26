package LCII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 4:55 PM
 */
public class NQueens {


    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];


        List<Integer> rows = new ArrayList<>();

        // 遍历第一行的所有列
        for (int i = 0; i < n; i++) {
            getMatrix(n, i, rows);
        }

        return res;
    }


    // 循环遍历
    private void getMatrix(int n, int index, List<Integer> rows) {
        if (rows.size() == n) {
            res.add(getboard(n,rows));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] != true && dia1[index + i] != true && dia2[index - i + n - 1] != true) {
                rows.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                getMatrix(n, index + 1, rows);
                rows.remove(rows.size() - 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

    private List<String> getboard(int n, List<Integer> rows){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c,'.');
            c[rows.get(i)] = 'Q';
            board.add(new String(c));
        }

        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new LC.NQueens().solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("=======================");
        }
    }

}