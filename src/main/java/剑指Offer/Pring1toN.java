package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-25 10:06
 **/
public class Pring1toN {
    public int[] printNumbers(int n) {
        int num  = 1;
        while(n > 0){
            num *= 10;
            n --;
        }
        System.out.println(num);
        int[] res = new int[num - 1];
        for (int i = 1; i < num; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Pring1toN().printNumbers(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
