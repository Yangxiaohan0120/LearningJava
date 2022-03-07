package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 6:58 PM
 */
public class Knapsnack {

    // 将n个物品放入容量为C的背包，使得价值最大
    // F(i,c) = F(i-1,c) // 不放入
    //        = v(i) + F(i-1,c-w(i)) // 放入
    // F(i,c) = max{F(i-1,c),v(i)+F(i-1,c-w(i))}

    int[][] memos; // index 列，c中 容量

    int[] memo;

    // 记忆搜索
    public int Knapsnack2(int[] w, int[] v, int c) {
        int n = w.length;
//        memo = new int[n][c + 1]; // index 列，c种 容量
//        memo = new int[2][c+1]; // 只使用两行的数组进行存储，不断覆盖
        memo = new int[c+1]; // 只使用一行的数组进行存储，不断覆盖
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < c + 1; j++) {
//                memo[i][j] = -1;
//            }
//        }
//        for (int j = 0; j <= c; j++) {
//            memo[0][j] = (j >= w[0] ? v[0] : 0); // 将index = 0的物品放入背包；
//        }

        for (int m = 0; m < c + 1; m++) {
            memo[m] = -1;
        }

        for (int k = 0; k <= c; k++) {
            memo[k] = (k >= w[0] ? v[0] : 0); // 将index = 0的物品放入背包；
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c; j++) {
//                memo[i][j] = memo[i - 1][j];
//                memo[i%2][j] = memo[(i-1)%2][j];
                if (j >= w[i]) {
                    memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
                }
            }
        }

//        return memo[n-1][c];
        return memo[c];
    }

    private int bestValue2(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) return 0;

        if (memos[index][c] != -1) {
            return memos[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return res;
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