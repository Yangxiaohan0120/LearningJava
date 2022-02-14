package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 6:58 PM
 */
public class Knapsnack {

    // 将n个物品放入容量为C的背包，使得价值最大
    // F(i,c) = F(i-1,c) // 不放入
    //        = v(i) + F(i-1,c-w(i)) // 放入
    // F(i,c) = max{F(i-1,c),v(i)+F(i-1,c-w(i))}

    int[][] memo; // index 列，c中 容量

    // 记忆搜索
    public int Knapsnack2(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n][c + 1]; // index 列，c种 容量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = -1;
            }
        }
        for (int j = 0; j <= c; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0); // 将index = 0的物品放入背包；
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n-1][c];
    }

    private int bestValue2(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) return 0;

        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return res;
    }


    // -------------------- 递归方法 --------------------//
    public int Knapsnack(int[] w, int[] v, int c) {
        int n = w.length;
        return bestValue(w, v, n - 1, c);
    }

    // 用[0...index]的物品，填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) return 0;

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return res;
    }


}