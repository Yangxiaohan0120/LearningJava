package Utils;

/**
 * @author Chris Yang
 * created 2022-04-06 20:23
 **/
public class printUtils<E> {

    public static<E> void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j == 0) {
                    System.out.print("{" + arr[i][j] + ",");
                } else if (j == arr[0].length - 1) {
                    System.out.println(arr[i][j] + "}");
                } else {
                    System.out.print(arr[i][j] + ",");
                }
            }
        }
    }
}
