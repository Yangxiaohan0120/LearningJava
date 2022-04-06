package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-02 17:33
 **/
public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
            if(n - res < i+1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1;
        int res = arrangeCoins(n);
        System.out.println(res);
    }
}
