package PTA;

import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 3:17 PM
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int m = 0;
        int total = 0;

        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int k = 0; k < m; k++) {
                if (i % arr[k] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                arr[m++] = i;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == 2) {
                total++;
            }
        }
        System.out.println(total);
    }
}