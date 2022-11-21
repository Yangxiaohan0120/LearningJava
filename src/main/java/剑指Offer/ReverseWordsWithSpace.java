package 剑指Offer;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-04 19:47
 **/
public class ReverseWordsWithSpace {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + ' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
//        return sb.toString().replaceAll("\\s+$","");

        int n = 2;
        return s.substring(n,s.length()).concat(s.substring(0,n));
    }


    public static void main(String[] args) {
        System.out.print(new ReverseWordsWithSpace().reverseWords("  hello world!  "));
        System.out.println("===");

    }
}
