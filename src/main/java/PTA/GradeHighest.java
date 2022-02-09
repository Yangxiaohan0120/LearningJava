package PTA;

import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 1:52 PM
 */
public class GradeHighest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = null;
        String max = null;
        String min = null;
        int maxN = 0;
        int minN = 100;
        for (int i = 0; i < n; i++) {
            s = scan.nextLine();
            String[] st = s.split(" ");
            if(Integer.parseInt(st[2]) > maxN){
                maxN = Integer.parseInt(st[2]);
                max = st[0]+" "+st[1];
            }
            if(Integer.parseInt(st[2]) < minN){
                minN = Integer.parseInt(st[2]);
                min = st[0] +" " + st[1];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}