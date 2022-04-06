package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-28 17:20
 **/
public class CountOddNumbers {
    public static int CountOddNumbers(int low,int high){
        int n = (high-low)/2;
        if(low%2 == 1 || high%2==1){
            n=n+1;
        }else {
            n = n;
        }

        return n;
    }

    public static void main(String[] args) {

    }
}
