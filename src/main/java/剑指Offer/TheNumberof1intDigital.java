package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-25 09:22
 **/
public class TheNumberof1intDigital {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
