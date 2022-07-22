package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 11:17
 **/
public class FindTargetInTwoDimensionArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0)return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11},
                {2,5,8,12},
                {10,13,14,17}};
        boolean res = new FindTargetInTwoDimensionArray().findNumberIn2DArray(matrix,9);
        System.out.println(res);
    }
}
