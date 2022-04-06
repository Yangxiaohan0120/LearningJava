package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-31 19:24
 **/
public class FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    n -= 1;
                    break;
                }
            }
        }
        return n;
    }
}
