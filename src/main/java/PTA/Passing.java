package PTA;

import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 1:16 PM
 */

import java.util.Scanner;

public class Passing {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = Integer.parseInt(scan.nextLine());
        String[] arr = {"10","PAT","PAAT","AAPATAA","AAPAATAAAA","xPATx","PT","Whatever","APAAATAA","APT","APATTAA"};
        int n = Integer.parseInt(arr[0]);

        for (int i = 0; i < n; i++) {
//            String s = scan.nextLine();
            String s = arr[i+1];
            String res = null;
            int[] c = new int[3];
            System.out.println(s);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - 'A' == 15) {
                    c[0]++;
                } else if (s.charAt(j) - 'A' == 0 && c[0] == 1 && c[1] == 0 && c[2] == 0) {
                    c[1]++;
                } else if (s.charAt(j) - 'A' == 19 && c[0] == 1 && c[1] == 1) {
                    c[2]++;
                } else if(s.charAt(j) - 'A' == 0) {
                    continue;
                }else {
                    System.out.println("NO");
                    break;
                }
            }
            if (c[0] == 1 && c[1] == 1 && c[2] == 1) {
                System.out.println("YES");
            }
        }
    }
}