package LeetCode;

/**
 * @author Chris Yang
 * created 2022-06-02 09:00
 **/
public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [[1,4,7],[2,5,8],[3,6,9]]
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] res = new TransposeMatrix().transpose(matrix);

        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[0].length; j++) {
                if(j == res[0].length -1){
                    System.out.print(res[i][j]);
                }else {
                    System.out.print(res[i][j] + ",");
                }
            }
            System.out.println("],");
        }
    }
}
