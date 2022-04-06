package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-02 17:40
 **/
public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int i = 0;
        int index = 0;
        int Z = 1;
        while(i < k){
            if(index < arr.length &&  arr[index] == Z){
                index ++;
                Z++;
            }else {
                Z++;
                i++;
            }
        }
        return Z-1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositive(arr,k));
    }
}
