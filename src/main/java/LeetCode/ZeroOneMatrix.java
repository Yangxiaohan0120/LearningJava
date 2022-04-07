package LeetCode;

import Utils.printUtils;

/**
 * @author Chris Yang
 * created 2022-04-06 15:26
 **/
public class ZeroOneMatrix {

    private int min;

    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0 || mat == null)
            return mat;

        int nrow = mat.length;
        int ncol = mat[0].length;

        int[][] dis = new int[nrow][ncol];
        boolean[][] visited = new boolean[nrow][ncol];

        // 逐行逐个遍历
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (mat[i][j] == 1) {
                    int count = 0;
                    min = Integer.MAX_VALUE;
                    searchNear(mat, dis, i, j, count, visited);// 知道寻找到最近的0为止
                    dis[i][j] = min;
                }
            }
        }

        return dis;
    }

    public void searchNear(int[][] mat, int[][] dis, int i, int j, int count, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j]) return;

        if (count > min) return;

        // 如果本层为0返回count
        if (mat[i][j] == 0) {
            min = Math.min(min, count);
            return;
        }

        visited[i][j] = true;

        // 如果未找到 从四个边进行遍历
        searchNear(mat, dis, i + 1, j, count + 1, visited); // 假设从下边找到的最近为2（第二层）
        searchNear(mat, dis, i, j + 1, count + 1, visited); // 从右边找到的最近为1 （Math.min(min,count) 会进行更新  Math.min(2,1)
        searchNear(mat, dis, i - 1, j, count + 1, visited);
        searchNear(mat, dis, i, j - 1, count + 1, visited);

        visited[i][j] = false;
        // 如果在其他层都找过的话，这次找的肯定是层数更多的，所以不再予以考虑，减少检索的次数。
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] dis = new ZeroOneMatrix().updateMatrix(mat);
        printUtils.print(dis);

    }
}
