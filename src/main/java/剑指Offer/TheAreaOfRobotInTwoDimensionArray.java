package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 15:39
 **/
public class TheAreaOfRobotInTwoDimensionArray {
    public int movingCount(int m, int n, int k) {
        int min = Math.min(m,n);
        int max = Math.max(m,n);
        int count = 0;
        for (int i = 0; i < min; i++) {
            for (int j = i; j < min; j++) {
                if((Count(i) + Count(j)) < k){
                    count++;
                }
            }
        }
        count *= 2;
        for (int i = min; i < max; i++) {

        }
        return 0;
    }

    public int Count(int n) {
        int a = n / 100;
        int b = (n - a * 100) / 10;
        int c = n - a * 100 - b * 10;
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(new TheAreaOfRobotInTwoDimensionArray().Count(100));
    }
}
