package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-27 19:28
 **/
public class SpiralOrderForMatrix {


    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length ==0)return new int[0];
        int k = 0;
        int l = 0, r = matrix[0].length - 1;
        int m = 0, n = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        while(true){
            for (int i = l; i <= r ; i++) {
                res[k++] = matrix[m][i];
            }
            if(++m > n)break;
            for (int i = m; i <= n; i++) {
                res[k++] = matrix[i][r];
            }
            if(--r < l)break;
            for (int i = r; i >= l ; i--) {
                res[k++] = matrix[n][i];
            }
            if(--n < m)break;
            for (int i = n; i >= m ; i--) {
                res[k++] = matrix[i][l];
            }
            if(++l > r)break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = new SpiralOrderForMatrix().spiralOrder(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
