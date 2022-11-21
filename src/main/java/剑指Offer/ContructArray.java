package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-05 10:24
 **/
public class ContructArray {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n == 0)return new int[0];
        int[] b = new int[n];
        b[0] = 1;
        for(int i = 1; i < n; i ++){
            b[i] = b[i - 1] * a[i-1];
        }
        int tmp = 1;
        for(int i = n-2;i>=0;i--){
            tmp *= a[i+1];
            b[i] = b[i] * tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new ContructArray().constructArr(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
