package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 1:14 PM
 */
public class NQueens {

    // 在棋盘格上放置皇后，不可以在同一行，同一列，同一斜线，皇后之间无法相互攻击
    // 利用剪枝的方法去除不可能的元素再进行递归

    // 使用x+y值的和相同来表示在同一个左向对角线 // 共有 2*n-1 个 序号为[0 -> 0+0[0,0], 1 -> 0+1[0,1] / 1+0[1,0] ...]
    // 值为[0...2n-1-1]  和与坐标相同
    // 使用x-y值的和相同来表示在同一个右向对角线 \\ 共有 2*n-1 个 序号为[0 -> 0-n+1 [0,n-1], 1 -> 0-n+2 [0,n-2] / 1-n+1 [1,n-1]
    // 值为[1-n,2-n,...,0,...,n-1] 统一向右挪 n-1 位 差加上n-1则为index

    List<List<String>> res;
    boolean[] col; //竖方向不冲突
    boolean[] dia1; // 左向对角线不冲突
    boolean[] dia2; // 右向对角线不冲突

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        for (int i = 0; i < col.length; i++) {
            col[i] = false;
        }

        for (int i = 0; i < dia2.length; i++) {
            dia1[i] = false;
            dia2[i] = false;
        }

        List<Integer> row = new ArrayList<>();
        putQueens(n,0,row);

        return res;
    }

    //在第index行，摆放皇后 按行摆放，index为行号，i为列号
    private void putQueens(int n, int index, List<Integer> row) {
        if (index == n) {
            // 完成一种可能性
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index+i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index+i] = true; // dia1的下标为坐标的x+y
                dia2[index - i + n - 1] = true; // dia2的下标为x-y+n-1
                putQueens(n,index+1,row);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size()-1);
            }
        }

        return;
    }

    private List<String> generateBoard(int n ,List<Integer> row){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rows = new char[n];
            Arrays.fill(rows, '.');
            rows[row.get(i)] = 'Q';
            board.add(new String(rows));
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<String>> res = new NQueens().solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("=======================");
        }
    }
}