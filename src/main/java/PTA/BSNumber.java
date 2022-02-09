package PTA;

import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 3:08 PM
 */
public class BSNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = n / 100;
        int b = (n - a * 100) / 10;
        int c = n % 10;
        while (a > 0) {
            System.out.print("B");
            a--;
        }
        while (b > 0) {
            System.out.print("S");
            b--;
        }
        for (int i = 1; i < c; i++) {
            System.out.print(i);
        }
    }
}