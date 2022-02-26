package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 3:02 PM
 */
public class Knapsnack {

    public int Knapsnack(int[] w, int[] v, int c) {
        int[] memo = new int[c + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 0;
        }

        // 放第一个物品的最大价值
        for (int i = 0; i < memo.length; i++) {
            if (w[0] <= c) memo[i] = v[0];
        }

        // 依次放入之后的物品
        for (int i = 1; i < w.length; i++) {
            // 对于不同的体积
            for (int j = 0; j <= c; j++) {
                if (j >= w[i]) //放得下
                    // memo[i] 不放这个，
                    // memo[j - w[i]] 放这个减去这个的体积
                    memo[i] = Math.max(memo[i], v[i] + (memo[j - w[i]]));
            }
        }

        return memo[c];
    }

}