package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-10 15:12
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        while(n!=0){
            ret =(ret*2) + (n %2);
            n =n/ 2;
        }
        return ret;
    }
}
