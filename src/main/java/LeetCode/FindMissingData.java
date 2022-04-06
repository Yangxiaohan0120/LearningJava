package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-28 16:10
 **/
public class FindMissingData {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = 0;
        int total = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }

        total = (mean) * (n + rolls.length) - sum;
        if(total < n || total > 6*n){
            return new int[0];
        }

        int mean1 = total/n;
        int l = total%n;
        for (int i = 0; i < res.length; i++) {
            res[i] = mean1;
        }
        for (int i = 0; i < l; i++) {
            res[i] += 1;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] rolls = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
        int mean = 4;
        int n = 40;
        int[] res = missingRolls(rolls,mean,n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
