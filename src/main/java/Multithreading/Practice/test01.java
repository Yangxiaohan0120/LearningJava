package Multithreading.Practice;

import com.beust.ah.A;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-20 19:01
 **/
public class test01 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] strs = new String[n];
//        int[] counts = new int[n];
//        for (int i = 0; i < n; i++) {
//            counts[i] = Integer.parseInt(scanner.nextLine());
//            strs[i] = scanner.nextLine();
//        }
//        int[] res = new int[n];
////        int[] counts = {7,4};
////        String[] strs = {"PAPAAPP","PPAP"};
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            boolean ans = false;
//
//            for (int j = 0; j < counts[i]; j++) {
//                char c = strs[i].charAt(j);
//                if(c == 'P' && ans){
//                    count ++;
//                }else if(c == 'A'){
//                    ans = true;
//                    res[i] = Math.max(res[i],count);
//                    count = 0;
//                }
//            }
//            res[i] = Math.max(res[i],count);
//            System.out.println(res[i]);
//        }

//        12
//                + 1
//                + 241
//                ? 1
//                + 361
//                - 241
//                ? 0101
//                + 101
//                ? 101
//                - 101
//                ? 101
//                + 4000
//                ? 0
//
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("241");
//        list.add("")
        MaxValue();
    }


    public static void MaxValue() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String chmod = scanner.nextLine();
            if (chmod.startsWith("+")) {
                list.add(chmod.split(" ")[1]);
            } else if (chmod.startsWith("-")) {
                list.remove(chmod.split(" ")[1]);
            } else {
                int ans = isOk(list, chmod.split(" ")[1]);
//                if (ans > 0) {
                    System.out.println(ans);
//                }
            }
        }
    }

    public static int isOk(ArrayList<String> list, String mod) {
        int m = mod.length();
        int ans = 0;
        for (String s : list) {
            boolean res = true;
            if (s.length() < m) {
                for (int i = 0; i < m - s.length(); i++) {
                    res &= mod.charAt(i) == '0';
                }
                for (int i = m - s.length(); i < m; i++) {
                    res &= (Integer.parseInt(s.substring(i - (m - s.length()),i - (m - s.length())+1)) % 2 == Integer.parseInt(mod.substring(i,i+1)));
                }
            } else {
                for (int i = 0; i < s.length() - m; i++) {
                    res &= (Integer.parseInt(s.substring(i,i+1)) % 2 == 0);
                }
                for (int i = s.length() - m; i < s.length(); i++) {
                    res &= (Integer.parseInt(s.substring(i,i+1)) % 2 == Integer.parseInt(mod.substring(i - (s.length() - m),i - (s.length() - m)+1)));
                }
            }
            if(res)ans ++;
        }
        return ans;
    }
}
