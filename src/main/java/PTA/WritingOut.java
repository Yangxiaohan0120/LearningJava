package PTA;

import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 1:14 PM
 */

import java.util.Scanner;

public class WritingOut {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n += s.charAt(i) - '0';
        }
        String[] values = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
        String out = String.valueOf(n);
        for (int i = 0; i < out.length()-1; i++) {
            System.out.print(values[out.charAt(i) - '0'] + " ");
        }
        System.out.println(values[out.charAt(out.length()-1) - '0']);
    }
}