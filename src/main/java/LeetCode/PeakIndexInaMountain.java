package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-31 19:20
 **/
public class PeakIndexInaMountain {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] - arr[i] < 0){
                return i;
            }
        }
        return arr.length-1;
    }
}
